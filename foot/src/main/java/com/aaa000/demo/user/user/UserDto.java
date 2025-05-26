package com.aaa000.demo.user.user;

import java.sql.Date;

public class UserDto {
	
	private String suSeq; //사용자 Seq
	private String userName; //사용자 이름
	private Integer userGender; // 사용자 성별
	private Integer userNewsAgency; //사용자 통신사
	private String userPhoneNumber; //사용자 폰번호
	private String userBirthday; //사용자 생일
	private String userId; //사용자 id
	private String userEmail; // 사용자 이메일
	private String userPassword; //사용자 페스워드
	private Integer uDelMy; // 데이터 삭제
//	----
//	-----
	private Integer xifcdSeqCount; // 코드 그룹 갯수
//	-----
// 코드 에있는  코드 이름  코드 Seq 땡겨오기
	private Integer  codeGroup_cdgSeq; // 코드 그룹 Seq
	private String cdSeq; //코드 Seq
	private String ifcdName;//코드 이름
//	-----
	private String genderCdSeq;
	private String genderName;
	private String telecomName;
	private String telecomCdSeq;
//	----
	private String cdgSeq;
	private String ifcgName;
//	----
//	검색 날짜
	private Date regDateTime;
	private Date modDateTime;
//	----
	
	public String getSuSeq() {
		return suSeq;
	}
	public void setSuSeq(String suSeq) {
		this.suSeq = suSeq;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserGender() {
		return userGender;
	}
	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
	}
	public Integer getUserNewsAgency() {
		return userNewsAgency;
	}
	public void setUserNewsAgency(Integer userNewsAgency) {
		this.userNewsAgency = userNewsAgency;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getuDelMy() {
		return uDelMy;
	}
	public void setuDelMy(Integer uDelMy) {
		this.uDelMy = uDelMy;
	}
	public Integer getXifcdSeqCount() {
		return xifcdSeqCount;
	}
	public void setXifcdSeqCount(Integer xifcdSeqCount) {
		this.xifcdSeqCount = xifcdSeqCount;
	}
	public Integer getCodeGroup_cdgSeq() {
		return codeGroup_cdgSeq;
	}
	public void setCodeGroup_cdgSeq(Integer codeGroup_cdgSeq) {
		this.codeGroup_cdgSeq = codeGroup_cdgSeq;
	}
	public String getCdSeq() {
		return cdSeq;
	}
	public void setCdSeq(String cdSeq) {
		this.cdSeq = cdSeq;
	}
	public String getIfcdName() {
		return ifcdName;
	}
	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}
	public String getGenderCdSeq() {
		return genderCdSeq;
	}
	public void setGenderCdSeq(String genderCdSeq) {
		this.genderCdSeq = genderCdSeq;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public String getTelecomName() {
		return telecomName;
	}
	public void setTelecomName(String telecomName) {
		this.telecomName = telecomName;
	}
	public String getTelecomCdSeq() {
		return telecomCdSeq;
	}
	public void setTelecomCdSeq(String telecomCdSeq) {
		this.telecomCdSeq = telecomCdSeq;
	}
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
