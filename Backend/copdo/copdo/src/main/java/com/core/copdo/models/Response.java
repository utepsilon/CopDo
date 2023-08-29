package com.core.copdo.models;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class Response {

    private HttpStatus status;

    private Object data;

    private LocalDateTime responseTime;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LocalDateTime getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(LocalDateTime responseTime) {
        this.responseTime = responseTime;
    }

    public Response(HttpStatus status, Object data, LocalDateTime responseTime) {
        this.status = status;
        this.data = data;
        this.responseTime = responseTime;
    }

    public Response() {
    }
}
