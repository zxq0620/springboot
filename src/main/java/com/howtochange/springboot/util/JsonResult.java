package com.howtochange.springboot.util;

/**
 * 封装json对象，所有返回结果都使用它
 */
public class JsonResult<T> {

	private boolean status;// 返回状态

	private T data;// 成功时返回的数据

	private String error;// 错误信息

	public JsonResult() {
	}

	// 成功时的构造器
	public JsonResult(boolean success, T data) {
		this.status = success;
		this.data = data;
	}

	// 错误时的构造器
	public JsonResult(boolean error, String errormsg) {
		this.status = error;
		this.error = errormsg;
	}

	public boolean isSuccess() {
		return status;
	}

	public void setSuccess(boolean success) {
		this.status = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "JsonResult [status=" + status + ", data=" + data + ", error=" + error + "]";
	}

}
