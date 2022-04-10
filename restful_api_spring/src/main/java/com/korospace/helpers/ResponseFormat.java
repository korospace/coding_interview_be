package com.korospace.helpers;

import com.google.gson.Gson;

public class ResponseFormat {
    private Integer code;

    private String status;

    private Object data;

    private String message;

    public ResponseFormat(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public ResponseFormat(Integer code, String status, Object data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public ResponseFormat(Integer code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public String output() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
