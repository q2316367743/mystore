package com.bookstore.vo;

public class ResultVo {
	
	private Integer code;
	private String message;
	public ResultVo(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public ResultVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
