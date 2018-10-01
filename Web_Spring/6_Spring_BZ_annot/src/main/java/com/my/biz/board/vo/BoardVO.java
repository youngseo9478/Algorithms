package com.my.biz.board.vo;

import java.io.Serializable;
import java.util.Date;

public class BoardVO implements Serializable {
	private int    seq     ;//    number(5) primary key,
	private String title   ;//    varchar2(100) not null,
	private String writer  ;//    varchar2(30) not null,
	private String content ;//    varchar2(2000) not null,
	private Date   regdate ;//    date  default sysdate,
	private int    cnt     ;//    number(5) default 0,
	private String userid  ;//    varchar2(8),
    
	String condition;
	String keyword;
	
	public BoardVO() {
		super();
	}

	public BoardVO(int seq, String title, String writer, String content, Date regdate, int cnt, String userid) {
		super();
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.cnt = cnt;
		this.userid = userid;
	}
 
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", cnt=" + cnt + ", userid=" + userid + "]";
	}
    
}
