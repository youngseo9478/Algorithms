package com.my.model;

public class UserInfo {
	String id;
	String name;
	String pw;
	String role;
	public UserInfo() {}
	public UserInfo(String id, String name, String pw, String role) {
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
		//String Builder 로 변환 ...
		return "UserInfo [id=" + id + ", name=" + name + ", pw=" + pw + ", role=" + role + "]";
	}
    
	
}
