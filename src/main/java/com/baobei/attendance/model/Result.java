package com.baobei.attendance.model;

import lombok.Data;

import java.util.Map;

/**
 * @author tcg
 * @date 2021/3/27
 */
@Data
public class Result {
    private String status;
    private String message;
    private Map<String, Object> data;


    public static Result retOk(String message) {
        Result res = new Result();
        res.setStatus(ReplyStatus.SUCCESS.name());
        res.setMessage(message);
        return res;
    }

    public static Result retOk(String message, Map<String, Object> data) {
        Result res = new Result();
        res.setStatus(ReplyStatus.SUCCESS.name());
        res.setMessage(message);
        res.setData(data);
        return res;
    }

    public static Result retOk(Map<String, Object> data) {
        Result res = new Result();
        res.setStatus(ReplyStatus.SUCCESS.name());
        res.setMessage("success");
        res.setData(data);
        return res;
    }

    public static Result retFail(String message) {
        Result res = new Result();
        res.setStatus(ReplyStatus.FAILED.name());
        res.setMessage(message);
        return res;
    }

    public static Result retFail(String message, Map<String, Object> data) {
        Result res = new Result();
        res.setStatus(ReplyStatus.FAILED.name());
        res.setMessage(message);
        res.setData(data);
        return res;
    }
}


