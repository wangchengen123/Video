package com.zhiyou.util;
/**
 * 
 * @author Administrator
 * 前后端交互时返回的固定的对象
 *   code : 返回的响应状态码
 *   msg  : 返回的信息
 *   data : 返回的数据
 */
public class ResultObject {
	private int code;
	private String msg;
	private Object data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "ResultObject [code=" + code + ", msg=" + msg + ", data=" + data + "]";
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
	public ResultObject(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public ResultObject() {
		super();
	}
	
}
