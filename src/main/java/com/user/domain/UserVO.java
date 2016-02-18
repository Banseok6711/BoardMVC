package com.user.domain;

import java.util.Date;

public class UserVO {
	
	private String userid;
	private String userpw;
	private String username;
	private String email;
	private int birth;
	private int phone;
	private Date regdate;	
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getUserid() {
		return userid;
	}
	public UserVO() {
		super();
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		
		String result ="";
		
		result = "userid:"+userid +"\n"+				
				"userpw:"+userpw+"\n"+
				"username:"+username+"\n"+				
				"birth:"+birth+"\n"+
				"email:"+email+"\n"+
				"phone:"+phone+"\n";
						
		return result;
	}
	
	
	
	

}
