package com.example.demo.service;

import com.example.demo.Endpoint;
import com.example.demo.ModemModel;
import com.example.demo.entities.authentication.AuthenticationRequest;
import com.example.demo.entities.authentication.JwtTokenProvider;
import com.example.demo.entities.modem.GetModemsResponse;
import com.example.demo.entities.modem.RemoveModemsRequest;
import com.example.demo.provider.ModemRevenueServicesProvider;
import com.example.demo.web.modem.states.ModemState;
import com.google.gson.Gson;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.scene.control.TableView;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class ModemDeleteService {

    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public void removeModems(TableView<ModemModel> tableView) {
        Gson gson = new Gson();
        String json = gson.toJson(RemoveModemsRequest.builder().modem(tableView.getItems()).build());
        RequestBody requestBody = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url(Endpoint.DELETE_MODEMS.getEndpoint())
                .put(requestBody)
                .addHeader("Authorization", JwtTokenProvider.getJwtTokenProvider().getBearer())
                .build();

        OkHttpClient client = new OkHttpClient();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
//            GetModemsResponse responseEntity = gson.fromJson(response.body().string(), GetModemsResponse.class);
//            ObservableListBase<ModemModel> list = (ObservableListBase<ModemModel>) tableView.getItems();
//            list.clear();
//            if (responseEntity.isOk()) {
//                list.addAll(responseEntity.getData());
//            }
//            tableView.setItems(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addModemsToTable(List<ModemModel> modems, TableView<ModemModel> tableView) {
        ObservableListBase<ModemModel> list = (ObservableListBase<ModemModel>) tableView.getItems();
        list.addAll(modems);
        tableView.setItems(list);
    }

    public void removeFromList(TableView<ModemModel> tableView) {
        ObservableList<ModemModel> modemsList = tableView.getItems();
        List<ModemModel> chosenModems = tableView.getSelectionModel().getSelectedItems();

        modemsList.removeAll(chosenModems);
        tableView.setItems(modemsList);
    }
}
