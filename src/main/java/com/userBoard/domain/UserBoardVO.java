package com.userBoard.domain;

import java.util.Date;

public class UserBoardVO {
	private int bno;
	private String userid;
	private String title;
	private String content;
	private String fileName;
	private String images;
	private int likCount;
	private Date regdate;
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getLike() {
		return likCount;
	}
	public void setLike(int like) {
		this.likCount = like;
	}
	@Override
	public String toString() {
		
		String info = "bno:"+getBno()+"\n"+
					"title:"+getTitle()	+"\n"+
					"content:"+getContent()+"\n"+
					"userid:"+getUserid()+"\n";
		return info; 
	}
	
	

}
