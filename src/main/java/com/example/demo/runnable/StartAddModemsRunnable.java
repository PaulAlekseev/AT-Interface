package com.example.demo.runnable;

import com.example.demo.Endpoint;
import com.example.demo.ModemModel;
import com.example.demo.entities.authentication.JwtTokenProvider;
import com.example.demo.entities.modem.AddModemsResponse;
import com.example.demo.entities.modem.GetModemsResponse;
import com.google.gson.Gson;
import javafx.collections.ObservableListBase;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class StartAddModemsRunnable implements Runnable{
    private final OkHttpClient client = new OkHttpClient();
    @Override
    public void run() {
        Request request = new Request.Builder()
                .url(Endpoint.ADD_MODEMS.getEndpoint())
                .get()
                .addHeader("Authorization", JwtTokenProvider.getJwtTokenProvider().getBearer())
                .build();
        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            AddModemsResponse responseEntity = gson.fromJson(response.body().string(), AddModemsResponse.class);
            if (responseEntity.isOk()) {
                System.out.println("OK");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
