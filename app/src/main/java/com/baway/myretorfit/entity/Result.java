package com.baway.myretorfit.entity;

/**
 * @author dingtao
 * @date 2019/5/10 10:55
 * qq:1940870847
 */
public class Result<T> {
    private String message="请求失败";
    private String status="-1";
    private T result;//请求结果

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
