package com.example.demo.runnable;

import com.example.demo.Endpoint;
import com.example.demo.TaskModel;
import com.example.demo.entities.authentication.JwtTokenProvider;
import com.example.demo.entities.task.GetTasksResponse;
import com.example.demo.provider.ModemIdProvider;
import com.google.gson.Gson;
import javafx.collections.ObservableListBase;
import javafx.scene.control.TableView;
import okhttp3.*;

import java.io.IOException;

public class TaskStartRunnable implements Runnable{
    public static final String SUCCESS_ANSWER = "ok";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();
    private final TableView<TaskModel> taskModelTableView;

    public TaskStartRunnable(TableView<TaskModel> taskModelTableView) {
        this.taskModelTableView = taskModelTableView;
    }

    @Override
    public void run() {
        HttpUrl url = HttpUrl.get(Endpoint.GET_TASKS.getEndpoint()).newBuilder()
                .addQueryParameter("modemId", String.valueOf(ModemIdProvider.getProvider().getModemId()))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Authorization", JwtTokenProvider.getJwtTokenProvider().getBearer())
                .build();
        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            GetTasksResponse responseObject = gson.fromJson(response.body().string(), GetTasksResponse.class);
            if (responseObject.isOk()) {
                ObservableListBase<TaskModel> list = (ObservableListBase<TaskModel>) taskModelTableView.getItems();
                list.clear();
                list.addAll(responseObject.getTasks());
                taskModelTableView.setItems(list);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
