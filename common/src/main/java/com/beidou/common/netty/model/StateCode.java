package com.beidou.common.netty.model;

public enum  StateCode {
	SUCCESS(1,"成功"),
	FAIL(0,"失败");

	private int code;
	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	StateCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public static String getMsgByCode(Integer code) {
		for (StateCode stateCode : StateCode.values()) {
			if (stateCode.getCode() == code) {
				return stateCode.msg;
			}
		}
		return null;
	}

	public static Integer getCodeByCode(Integer code) {
		for (StateCode stateCode : StateCode.values()) {
			if (stateCode.getCode() == code) {
				return stateCode.code;
			}
		}
		return null;
	}
}
