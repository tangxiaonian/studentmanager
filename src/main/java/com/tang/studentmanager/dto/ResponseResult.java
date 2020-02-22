package com.tang.studentmanager.dto;

import lombok.Data;

/**
 * @Classname ResponseResult
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 10:25
 * @Created by ASUS
 */
@Data
public class ResponseResult<T> {

    /**
     * 状态码
     */
    private Integer state;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回对象
     */
    private T data;

    public ResponseResult() { }

    public ResponseResult(Integer state) { }

    public ResponseResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public ResponseResult(Integer state, Throwable throwable) {
        this.state = state;
        this.message = throwable.getMessage();
    }

    public ResponseResult(Integer state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public static <M> ResponseResult<M> Ok(Integer state, String message, M data){
        return new ResponseResult<M>(state, message, data);
    }

}