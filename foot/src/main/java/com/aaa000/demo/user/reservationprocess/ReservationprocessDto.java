package com.aaa000.demo.user.reservationprocess;

import java.util.Date;

import com.aaa000.demo.module.base.BaseDto;

public class ReservationprocessDto extends BaseDto{
	
	private String fpSeq;
//	풋살장 예약
	
	private String reservationDate; //풋살장 예약날짜
	private String reservationTime; //풋살장 예약시간
// 풋살장 매칭 등록
	private String matchingOnOff; //풋살매칭 등록 신청OnOff
	private Integer matchingDeposit;//매칭 등록시 금액설정
	private String matchingBankName;//매칭 등록시 받을 은행명설정
	private String matchingBankNumbar;//매칭 등록시 받을 은행 계좌번호
	private String matchingVs; // 몇vs몇
	private String matchingTeamLevel; //매칭 등록 레벨 설정
	private String matchingTeamName; //매칭 등록 팀 이름
	private String matchingTeamIntroduction; //매칭 등록 팀소개
// 풋살장 매칭 신청
	private String applicationTeamLevel; //매칭 신청 팀레벨
	private String applicationTeamPhoneNumbar;//매칭 팀 신청 번호
	private String applicationTeamName; //매칭 신청팀 이름
	private String applicationTeamIntroduction;//매칭 신청 팅 소개
// 풋살장 결제
	private String paymentMethod;//결제 방법(토스,카카오,페이코,네이버,카드)
	private String cardNumbar; //카드 번호
	private String cardHolderName;//카드 소유주 이름
	private String expirationDate;// 만료일
	private String cvv; // cvv번호
	private String paymentStatus; //결제 상태(성공,실패)
// 업데이트 삭제
	private Integer rpDelMy;
// Seq
	private String user_suSeq; //유저 Seq
	private String futsalInformation_fiSeq; // 풋살 결제 매칭 Seq	
	private String user_suSeq1; // 매칭 신청 유저Seq
//	----
// 유저 Seq 가져오기
	private String suSeq; //유저Seq
	private String userName; //유저 이름
	private String userId; //유저 ID
	private String userPhoneNumber;
//	----	
//	---- 
	//풋살장 정보
	private String fiSeq; // 풋살장정보Seq
	private String futsalName; //풋살장 이름
	private String futsalRegion; //서울or경기 지역
	private String futsalAddress; //풋살장 주소
	private String futsalPhoneNumbar;
	private Integer futsalPrice;
	private String detailedAddress;
	private String futsalBusinessHours;
	private String futsalFacilityUsageRules;
//	-----
	
	
	
	public String getFpSeq() {
		return fpSeq;
	}
	public void setFpSeq(String fpSeq) {
		this.fpSeq = fpSeq;
	}
	
	public String getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getMatchingOnOff() {
		return matchingOnOff;
	}
	public void setMatchingOnOff(String matchingOnOff) {
		this.matchingOnOff = matchingOnOff;
	}
	public Integer getMatchingDeposit() {
		return matchingDeposit;
	}
	public void setMatchingDeposit(Integer matchingDeposit) {
		this.matchingDeposit = matchingDeposit;
	}
	public String getMatchingBankName() {
		return matchingBankName;
	}
	public void setMatchingBankName(String matchingBankName) {
		this.matchingBankName = matchingBankName;
	}
	public String getMatchingBankNumbar() {
		return matchingBankNumbar;
	}
	public void setMatchingBankNumbar(String matchingBankNumbar) {
		this.matchingBankNumbar = matchingBankNumbar;
	}
	public String getMatchingVs() {
		return matchingVs;
	}
	public void setMatchingVs(String matchingVs) {
		this.matchingVs = matchingVs;
	}
	public String getMatchingTeamLevel() {
		return matchingTeamLevel;
	}
	public void setMatchingTeamLevel(String matchingTeamLevel) {
		this.matchingTeamLevel = matchingTeamLevel;
	}
	public String getMatchingTeamName() {
		return matchingTeamName;
	}
	public void setMatchingTeamName(String matchingTeamName) {
		this.matchingTeamName = matchingTeamName;
	}
	public String getMatchingTeamIntroduction() {
		return matchingTeamIntroduction;
	}
	public void setMatchingTeamIntroduction(String matchingTeamIntroduction) {
		this.matchingTeamIntroduction = matchingTeamIntroduction;
	}
	public String getApplicationTeamLevel() {
		return applicationTeamLevel;
	}
	public void setApplicationTeamLevel(String applicationTeamLevel) {
		this.applicationTeamLevel = applicationTeamLevel;
	}
	public String getApplicationTeamPhoneNumbar() {
		return applicationTeamPhoneNumbar;
	}
	public void setApplicationTeamPhoneNumbar(String applicationTeamPhoneNumbar) {
		this.applicationTeamPhoneNumbar = applicationTeamPhoneNumbar;
	}
	public String getApplicationTeamName() {
		return applicationTeamName;
	}
	public void setApplicationTeamName(String applicationTeamName) {
		this.applicationTeamName = applicationTeamName;
	}
	public String getApplicationTeamIntroduction() {
		return applicationTeamIntroduction;
	}
	public void setApplicationTeamIntroduction(String applicationTeamIntroduction) {
		this.applicationTeamIntroduction = applicationTeamIntroduction;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getCardNumbar() {
		return cardNumbar;
	}
	public void setCardNumbar(String cardNumbar) {
		this.cardNumbar = cardNumbar;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Integer getRpDelMy() {
		return rpDelMy;
	}
	public void setRpDelMy(Integer rpDelMy) {
		this.rpDelMy = rpDelMy;
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
	public String getFutsalPhoneNumbar() {
		return futsalPhoneNumbar;
	}
	public void setFutsalPhoneNumbar(String futsalPhoneNumbar) {
		this.futsalPhoneNumbar = futsalPhoneNumbar;
	}
	public Integer getFutsalPrice() {
		return futsalPrice;
	}
	public void setFutsalPrice(Integer futsalPrice) {
		this.futsalPrice = futsalPrice;
	}
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
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

	public String getUser_suSeq1() {
		return user_suSeq1;
	}
	public void setUser_suSeq1(String user_suSeq1) {
		this.user_suSeq1 = user_suSeq1;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	
	
	
}
