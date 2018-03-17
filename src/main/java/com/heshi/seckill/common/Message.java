package com.heshi.seckill.common;

/**
 * @author Paosin
 * @version 1.0
 * @className Message
 * @date 2018/3/17 22:09
 */
public class Message {
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_FAIL = 100;

    private Integer code;
    private String msg;
    private Object data;

    private Message() {
    }

    private Message(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Message getSuccess() {
        return new Message(CODE_SUCCESS, null, null);
    }

    public static Message getSuccess(String str, Object data) {
        return new Message(CODE_SUCCESS, str, data);
    }

    public static Message getSuccess(Object data) {
        return new Message(CODE_SUCCESS, null, data);
    }

    public static Message getSuccess(String str) {
        return new Message(CODE_SUCCESS, str, null);
    }

    public static Message getFail(String str) {
        return new Message(CODE_FAIL, str, null);
    }

    public static Message getFail() {
        return new Message(CODE_FAIL, null, null);
    }
}
