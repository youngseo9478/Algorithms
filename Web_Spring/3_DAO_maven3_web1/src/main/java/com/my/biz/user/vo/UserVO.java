package com.my.biz.user.vo;

import java.io.Serializable;

public class UserVO implements Serializable{
	String id     ;//       varchar2(8) primary key,
	String name   ;//       varchar2(20) not null,
	String pw     ;//       varchar2(8) not null,
	String role   ;//       varchar2(5) default 'User'
	
	public UserVO() {}
	public UserVO(String id, String name, String pw, String role) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", pw=" + pw + ", role=" + role + "]";
	}
}
