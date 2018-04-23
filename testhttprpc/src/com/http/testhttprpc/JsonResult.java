/**
 * 
 */
package com.http.testhttprpc;

/**
 * @Description: json结果集
 **/
public class JsonResult {

	// 结果状态码
	private int resultCode;
	// 状态码解释消息
	private String message;
	// 结果对象
	private Object result;
	
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	
}
