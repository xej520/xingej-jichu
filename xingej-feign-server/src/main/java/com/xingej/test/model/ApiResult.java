package com.xingej.test.model;

public class ApiResult {

    private boolean result;
    private Object data;
    private String message;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApiResult(boolean result, Object data, String message) {
        super();
        this.result = result;
        this.data = data;
        this.message = message;
    }

    public ApiResult() {
    }

}
