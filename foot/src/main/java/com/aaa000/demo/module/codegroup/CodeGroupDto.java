package com.aaa000.demo.module.codegroup;

import java.sql.Date;

public class CodeGroupDto {
	
	private String cdgSeq;
	private String ifcgName;
	private Integer ifchDelNy; //지운 여부
	private Integer newsAgency; // 통신사
	private Integer gender; // 성별
	private String usedOrNot;// 등록 여부
	private String registration;// 등록날짜
	private String correction;//수정일
	private Integer count; //갯수

//	-----
	private Integer xifcdSeqCount; // 코드 그룹 갯수
//	-----
//	검색 날짜
	private Date regDateTime;
	private Date modDateTime;
//	----
	
	
	public String getCdgSeq() {
		return cdgSeq;
	}
	public void setCdgSeq(String cdgSeq) {
		this.cdgSeq = cdgSeq;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	public Integer getIfchDelNy() {
		return ifchDelNy;
	}
	public void setIfchDelNy(Integer ifchDelNy) {
		this.ifchDelNy = ifchDelNy;
	}
	public Integer getNewsAgency() {
		return newsAgency;
	}
	public void setNewsAgency(Integer newsAgency) {
		this.newsAgency = newsAgency;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getUsedOrNot() {
		return usedOrNot;
	}
	public void setUsedOrNot(String usedOrNot) {
		this.usedOrNot = usedOrNot;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getCorrection() {
		return correction;
	}
	public void setCorrection(String correction) {
		this.correction = correction;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getXifcdSeqCount() {
		return xifcdSeqCount;
	}
	public void setXifcdSeqCount(Integer xifcdSeqCount) {
		this.xifcdSeqCount = xifcdSeqCount;
	}
	public Date getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(Date regDateTime) {
		this.regDateTime = regDateTime;
	}
	public Date getModDateTime() {
		return modDateTime;
	}
	public void setModDateTime(Date modDateTime) {
		this.modDateTime = modDateTime;
	}
	
	
	
	
}
