package com.example.demo;

public enum Endpoint {
    AUTHENTICATION("api/v1/auth/authenticate"),
    UPDATE_TOKEN("api/v1/auth/refreshToken"),
    START_PROVIDER("api/v1/provider/start"),
    STOP_PROVIDER("api/v1/provider/stop"),
    SAVE_MODEMS("api/v1/provider/saveModems"),
    GET_MODEMS("api/v1/provider/getModems"),
    GET_TASKS("api/v1/provider/getTasks"),
    GET_BY_CRITERIA("api/v1/provider/getByCriteria"),
    DELETE_MODEMS("api/v1/provider/disconnectModems"),
    ADD_MODEMS("api/v1/provider/addModems");


    private static String index = "url";
    private String endpoint;

    Endpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return index + endpoint;
    }
}
