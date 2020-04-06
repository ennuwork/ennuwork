package com.eunco.demonstrate.util;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 封装前端返回的统一实体类
 * @author ennu
 * @param <T>
 */
public class UniteMessage<T> {

    /**
     * 状态  0: 接口调用成功
     */
    private int status;

    /**
     * 当status=0时, 将返回的结果封装到data中
     */
    private T data;

    /**
     * 提示信息
     */
    private String msg;

    private UniteMessage() {

    }

    private UniteMessage(int status) {
        this.status = status;
    }

    private UniteMessage(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private UniteMessage(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 判断接口是否成功
     * @return
     */
    @JsonIgnore
    public boolean isSuccess() {
        return this.status == 0;
    }

    /**
     * 成功时返回信息
     * @return
     */
    public static UniteMessage createUniteMessageBySuccess() {
        return new UniteMessage(0);
    }
    public static <T> UniteMessage createUniteMessageBySuccess(T data) {
        return new UniteMessage(0, data);
    }
    public static <T> UniteMessage createUniteMessageBySuccess(T data, String msg) {
        return new UniteMessage(0, data, msg);
    }

    /**
     * 失败时返回信息
     * @param status
     * @return
     */
    public static UniteMessage createUniteMessageByFail(int status) {
        return new UniteMessage(status);
    }
    public static UniteMessage createUniteMessageByFail(int status, String msg) {
        return new UniteMessage(status, null, msg);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
