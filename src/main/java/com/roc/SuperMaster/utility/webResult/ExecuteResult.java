package com.roc.SuperMaster.utility.webResult;

import java.io.Serializable;

/**
 * 响应包装类
 */

public class ExecuteResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success; //是否成功
    private T data;//数据
    private String error;//错误

    public ExecuteResult() {
    }

    public void setData(T data) {
        this.success = true;
        this.data = data;
    }

    public void setError(String error) {
        this.success = false;
        this.error = error;
    }

    public static <T> ExecuteResult<T> ok(T data) {
        ExecuteResult<T> resp = new ExecuteResult();
        resp.setData(data);
        return resp;
    }

    public static <T> ExecuteResult<T> ok() {
        return ok((T) null);
    }

    public static <T> ExecuteResult<T> fail(String error) {
        ExecuteResult<T> resp = new ExecuteResult();
        resp.setError(error);
        return resp;
    }

    public String toString() {
        return "Response(success=" + this.isSuccess() + ", data=" + this.getData() + ", error=" + this.getError() + ")";
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return this.data;
    }

    public String getError() {
        return this.error;
    }
}
