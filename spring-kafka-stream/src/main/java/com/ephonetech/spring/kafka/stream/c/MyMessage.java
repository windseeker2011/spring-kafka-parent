package com.ephonetech.spring.kafka.stream.c;

import java.io.Serializable;

/**
 * 自定义的一个消息实体
 * 
 * @author Weihai Li
 *
 */
public class MyMessage implements Serializable {

	private static final long serialVersionUID = 2216602936486278218L;

	private Integer id;

	private String msg;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MyMessage [id=" + id + ", msg=" + msg + "]";
	}

}
