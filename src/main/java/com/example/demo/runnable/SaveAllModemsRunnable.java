package com.example.demo.runnable;

import com.example.demo.Endpoint;
import com.example.demo.entities.authentication.JwtTokenProvider;
import okhttp3.*;

import java.io.IOException;

public class SaveAllModemsRunnable implements Runnable{
    public static final String SUCCESS_ANSWER = "ok";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();

    @Override
    public void run() {
        RequestBody requestBody = RequestBody.create("", JSON);
        Request request = new Request.Builder()
                .url(Endpoint.SAVE_MODEMS.getEndpoint())
                .post(requestBody)
                .addHeader("Authorization", JwtTokenProvider.getJwtTokenProvider().getBearer())
                .build();
        try (Response response = client.newCall(request).execute()) {
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
