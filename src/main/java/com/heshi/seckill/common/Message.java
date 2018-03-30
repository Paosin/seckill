package com.heshi.seckill.common;

import org.springframework.http.HttpStatus;

/**
 * @author Paosin
 * @version 1.0
 * @className Message
 * @date 2018/3/17 22:09
 */
public class Message {
    private Integer code;
    private String msg;
    private Object data;

    private Message() {
    }

    public Message(HttpStatus code, String msg, Object data) {
        this.code = code.value();
        this.msg = msg;
        this.data = data;
    }

    public static Message getSuccess() {
        return new Message(HttpStatus.OK, null, null);
    }

    public static Message getSuccess(String str, Object data) {
        return new Message(HttpStatus.OK, str, data);
    }

    public static Message getSuccess(String str) {
        return new Message(HttpStatus.OK, str, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
