package com.korospace.helpers;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.korospace.models.entities.Product;

public class ResponseProduct {
    
    private Integer code;
    
    private String status;

    @JsonInclude(Include.NON_NULL)
    private Object messages;

    @JsonInclude(Include.NON_NULL)
    private Object data;

    public ResponseProduct(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public ResponseProduct(Integer code, String status, String messages) {
        this.code = code;
        this.status = status;
        this.messages = messages;
    }

    public ResponseProduct(Integer code, String status, Map<String,String> messages) {

        this.code = code;
        this.status = status;
        this.messages = messages;
    }

    public ResponseProduct(Integer code, String status, Iterable<Product> data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public ResponseProduct(Integer code, String status, Product data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getMessages() {
        return messages;
    }

    public void setMessages(Object messages) {
        this.messages = messages;
    }

    public Object getData() {
        return data;
    }

    public void setData(Product data) {
        this.data = data;
    }
    
    
}
