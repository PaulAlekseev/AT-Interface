package com.example.demo.runnable;

import com.example.demo.Endpoint;
import com.example.demo.ModemModel;
import com.example.demo.entities.authentication.JwtTokenProvider;
import com.example.demo.entities.modem.GetModemsResponse;
import com.google.gson.Gson;
import javafx.collections.ObservableListBase;
import javafx.scene.control.TableView;
import okhttp3.*;

import java.io.IOException;

public class GetModemsRunnable implements Runnable {
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();
    private final TableView<ModemModel> tableView;

    public GetModemsRunnable(TableView<ModemModel> tableView) {
        this.tableView = tableView;
    }

    @Override
    public void run() {
        RequestBody requestBody = RequestBody.create("", JSON);
        Request request = new Request.Builder()
                .url(Endpoint.GET_MODEMS.getEndpoint())
                .get()
                .addHeader("Authorization", JwtTokenProvider.getJwtTokenProvider().getBearer())
                .build();
        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            GetModemsResponse responseEntity = gson.fromJson(response.body().string(), GetModemsResponse.class);
            if (responseEntity.isOk()) {
                ObservableListBase<ModemModel> list = (ObservableListBase<ModemModel>) tableView.getItems();
                list.clear();
                list.addAll(responseEntity.getData());
                tableView.setItems(list);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
