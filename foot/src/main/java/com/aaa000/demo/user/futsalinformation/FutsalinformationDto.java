package com.aaa000.demo.user.futsalinformation;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;

import com.aaa000.demo.module.base.BaseDto;

public class FutsalinformationDto extends BaseDto{
	
	private Integer fiSeq; // 풋살장정보Seq
	private String futsalName; //풋살장 이름
	private Integer futsalPrice; //가격
	private String futsalRegion; //서울or경기 지역
	private String futsalAddress; //풋살장 주소
	private String futsalPhoneNumbar; //풋살장 번호
	private String futsalBusinessHours; //풋살장 영업시간
	private String futsalFacilityUsageRules; //풋살장 이용규칙
	private String futsalCancellationPolicy; //풋살장 취소정책
	private Integer fiDelMy; // 업데이트 삭제
	private String zipCode; //우편번호
	private String detailedAddress; //상세주소
	private Double latitude; //위도
	private Double hardness; //경도
//	-----
// 코드 에있는  코드 이름  코드 Seq 땡겨오기
	private Integer  codeGroup_cdgSeq; // 코드 그룹 Seq
	private String cdSeq; //코드 Seq
	private String ifcdName;//코드 이름
//	-----
//	검색 날짜
	private String regDateTime;
	private String modDateTime;
//	----
	//리뷰
	private String rSeq; //리뷰 Seq
	private Integer starScore; //리뷰 별점
	private String reviewTitle; //리뷰 제목
	private String reviewText; // 리뷰 내용
	private String user_suSeq; //사용자 정보 Seq
	private String futsalInformation_fiSeq; //풋살장정보 Seq 
//	-----
	// 유저
	private String suSeq; // 유저Seq 
	private String userName; // 유저이름
	private String userId; //유저ID
	private String userEmail;
	private String favoritesSeq;
//	----
	 private Integer  fdelMy;
	 @Value("${toss.client-key}")
	 private String clientKey;

	 @Value("${toss.secret-key}")
	 private String secretKey;
//	----
	 
	
	public Integer getFiSeq() {
		return fiSeq;
	}
	public void setFiSeq(Integer fiSeq) {
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
	public String getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}
	public String getModDateTime() {
		return modDateTime;
	}
	public void setModDateTime(String modDateTime) {
		this.modDateTime = modDateTime;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getHardness() {
		return hardness;
	}
	public void setHardness(Double hardness) {
		this.hardness = hardness;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setIsFavorited(Integer  isFavorited2) {
		// TODO Auto-generated method stub
		
	}
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getFavoritesSeq() {
		return favoritesSeq;
	}
	public void setFavoritesSeq(String favoritesSeq) {
		this.favoritesSeq = favoritesSeq;
	}
	public Integer getFdelMy() {
		return fdelMy;
	}
	public void setFdelMy(Integer fdelMy) {
		this.fdelMy = fdelMy;
	}
	
	
	
}
