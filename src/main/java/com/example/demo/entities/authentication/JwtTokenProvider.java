package com.example.demo.entities.authentication;

import com.example.demo.Endpoint;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Getter;
import lombok.Setter;
import okhttp3.*;

import java.io.IOException;

public class JwtTokenProvider {
    private static final String REFRESH_TOKEN_ANSWER = "refreshToken";
    private static final String AUTH_TOKEN = "authToken";
    private static final String SUCCESS_ANSWER = "ok";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static JwtTokenProvider jwtTokenProvider;
    @Getter
    @Setter
    private String accessToken;
    @Getter
    @Setter
    private String refreshToken;

    private JwtTokenProvider(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public static JwtTokenProvider getJwtTokenProvider() {
        return jwtTokenProvider;
    }

    public static JwtTokenProvider setJwtTokenProvider(String accessToken, String refreshToken) {
        jwtTokenProvider = new JwtTokenProvider(accessToken, refreshToken);
        return jwtTokenProvider;
    }

    public static boolean updateAccessToken() {
        AuthenticationCredentialsHolder credentialsHolder = AuthenticationCredentialsHolder.getCredentialsHolder();
        if (credentialsHolder.getEmail() == null && credentialsHolder.getPassword() == null) return false;
        if (jwtTokenProvider.refreshToken == null) return false;
        Gson gson = new Gson();
        String json = gson.toJson(new RefreshTokenRequest(jwtTokenProvider.getRefreshToken()));
        RequestBody requestBody = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(Endpoint.UPDATE_TOKEN.getEndpoint())
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        try (Response response = client.newCall(request).execute()) {
            JsonObject object = JsonParser.parseString(response.body().string()).getAsJsonObject();
            System.out.println(object.get(SUCCESS_ANSWER).getAsBoolean());
            if (object.get(SUCCESS_ANSWER).getAsBoolean()) {
                jwtTokenProvider.setAccessToken(object.get(AUTH_TOKEN).getAsString());
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static JwtTokenProvider authenticate(String login, String password) {
        Gson gson = new Gson();
        String json = gson.toJson(new AuthenticationRequest(login, password));
        RequestBody requestBody = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(Endpoint.AUTHENTICATION.getEndpoint())
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        try (Response response = client.newCall(request).execute()) {
            JsonObject object = JsonParser.parseString(response.body().string()).getAsJsonObject();
            if (object.get(SUCCESS_ANSWER).getAsBoolean()) {
                AuthenticationCredentialsHolder.setCredentialsHolder(login, password);
                setJwtTokenProvider(
                        object.get(AUTH_TOKEN).getAsString(),
                        object.get(REFRESH_TOKEN_ANSWER).getAsString());
                return getJwtTokenProvider();
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }

    public String getBearer() {
        return "Bearer " + getAccessToken();
    }
}
