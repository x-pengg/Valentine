package me.ridog.valentine.resp;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tate on 2016/7/29.
 */
public class APIResult {


    private Integer status;

    private Integer errCode;

    private String errMsg;

    private Object data;

    public APIResult(){}

    public static APIResult newRs(){
        return new APIResult();
    }

    public APIResult success(){
        this.status = ErrorCode.EXECUTE_SUCCESS;
        return this;
    }

    public APIResult fail(){
        this.status = ErrorCode.EXECUTE_FAIL;
        return this;
    }

    public APIResult errCode(){
        this.errCode = ErrorCode.PARAM_ERROR;
        return this;
    }

    public APIResult errCode(Integer errCode){
        this.errCode = errCode;
        return this;
    }

    public APIResult errMsg(String errMsg){
        this.errMsg = errMsg;
        return this;
    }

    public APIResult data(Object data){
        this.data = data;
        return this;
    }

    public String build(){
        return JSONObject.toJSONString(this);
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public Object getData() {
        return data;
    }
}
