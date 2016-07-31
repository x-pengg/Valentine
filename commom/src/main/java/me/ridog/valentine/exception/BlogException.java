package me.ridog.valentine.exception;

/**
 * Created by Tate on 2016/7/29.
 */
public final class BlogException extends RuntimeException {

    private Integer code;
    private String msg;

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

    public BlogException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BlogException() {
    }


}
