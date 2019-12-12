package com.simple.www.vo;

import java.text.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.*;
/**
 * 이 클래스는 회원정보에 대한 데이터를 저장해서
 *  넘겨주는 용도로 사용할 클래스( DTO 또는 VO )
 *  
 * @author	김산하
 * @since	2019.11.12
 * @version	v.1.0
 * 
 * 			변경이력
 * 				2019.11.12	-	클래스 제작 	- 	담당자 : 김산하
 * 				2019.12.10	- 	jsp프로젝트에서 spring 프로젝트로 클래스 복사
 * 											- 	담당자 : 김산하
 * 
 */
public class BoardVO {
	private int mno;
	private String id;
	private String pw;
	private String name;
	private String mail;
	private String tel;
	private Date joinDate;
	private Time joinTime;
	private String sDate;
	private String sTime;
	
	
	
	
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Time getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Time joinTime) {
		this.joinTime = joinTime;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String getsTime() {
		return sTime;
	}
	public void setsTime() {
		SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
		this.sTime = form.format(joinTime);
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	public void setsDate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		this.sDate = form.format(joinDate);
	}
}