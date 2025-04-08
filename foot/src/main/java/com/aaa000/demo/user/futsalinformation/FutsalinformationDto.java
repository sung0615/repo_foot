package com.aaa000.demo.user.futsalinformation;

import java.sql.Date;

public class FutsalinformationDto {
	
	private String fiSeq; // 풋살장정보Seq
	private String futsalName; //풋살장 이름
	private Integer futsalPrice; //가격
	private String futsalRegion; //서울or경기 지역
	private String futsalAddress; //풋살장 주소
	private String futsalPhoneNumbar; //풋살장 번호
	private String futsalBusinessHours; //풋살장 영업시간
	private String futsalFacilityUsageRules; //풋살장 이용규칙
	private String futsalCancellationPolicy; //풋살장 취소정책
	private Integer fiDelMy; // 업데이트 삭제
//	-----
// 코드 에있는  코드 이름  코드 Seq 땡겨오기
	private Integer  codeGroup_cdgSeq; // 코드 그룹 Seq
	private String cdSeq; //코드 Seq
	private String ifcdName;//코드 이름
//	-----
//	검색 날짜
	private Date regDateTime;
	private Date modDateTime;
//	----
	
	public String getFiSeq() {
		return fiSeq;
	}
	public void setFiSeq(String fiSeq) {
		this.fiSeq = fiSeq;
	}
	public String getFutsalName() {
		return futsalName;
	}
	public void setFutsalName(String futsalName) {
		this.futsalName = futsalName;
	}
	public Integer getFutsalPrice() {
		return futsalPrice;
	}
	public void setFutsalPrice(Integer futsalPrice) {
		this.futsalPrice = futsalPrice;
	}
	public String getFutsalRegion() {
		return futsalRegion;
	}
	public void setFutsalRegion(String futsalRegion) {
		this.futsalRegion = futsalRegion;
	}
	public String getFutsalAddress() {
		return futsalAddress;
	}
	public void setFutsalAddress(String futsalAddress) {
		this.futsalAddress = futsalAddress;
	}
	public String getFutsalPhoneNumbar() {
		return futsalPhoneNumbar;
	}
	public void setFutsalPhoneNumbar(String futsalPhoneNumbar) {
		this.futsalPhoneNumbar = futsalPhoneNumbar;
	}
	public String getFutsalBusinessHours() {
		return futsalBusinessHours;
	}
	public void setFutsalBusinessHours(String futsalBusinessHours) {
		this.futsalBusinessHours = futsalBusinessHours;
	}
	public String getFutsalFacilityUsageRules() {
		return futsalFacilityUsageRules;
	}
	public void setFutsalFacilityUsageRules(String futsalFacilityUsageRules) {
		this.futsalFacilityUsageRules = futsalFacilityUsageRules;
	}
	public String getFutsalCancellationPolicy() {
		return futsalCancellationPolicy;
	}
	public void setFutsalCancellationPolicy(String futsalCancellationPolicy) {
		this.futsalCancellationPolicy = futsalCancellationPolicy;
	}
	public Integer getFiDelMy() {
		return fiDelMy;
	}
	public void setFiDelMy(Integer fiDelMy) {
		this.fiDelMy = fiDelMy;
	}
//	-----
	//리뷰
	private String rSeq; //리뷰 Seq
	private Integer starScore; //리뷰 별점
	private String user_suSeq; //사용자 정보 Seq
	private String futsalInformation_fiSeq; //풋살장정보 Seq 
//	-----
	public String getrSeq() {
		return rSeq;
	}
	public void setrSeq(String rSeq) {
		this.rSeq = rSeq;
	}
	public Integer getStarScore() {
		return starScore;
	}
	public void setStarScore(Integer starScore) {
		this.starScore = starScore;
	}
	public String getUser_suSeq() {
		return user_suSeq;
	}
	public void setUser_suSeq(String user_suSeq) {
		this.user_suSeq = user_suSeq;
	}
	public String getFutsalInformation_fiSeq() {
		return futsalInformation_fiSeq;
	}
	public void setFutsalInformation_fiSeq(String futsalInformation_fiSeq) {
		this.futsalInformation_fiSeq = futsalInformation_fiSeq;
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
