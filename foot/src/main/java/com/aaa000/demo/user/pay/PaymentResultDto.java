package com.aaa000.demo.user.pay;

import org.joda.time.LocalDateTime;

public class PaymentResultDto {
	
    private String paymentKey;
    private String orderId;
    private Integer amount;
//	---- 예약정보
    private String fpSeq;
    private String reservationDate;
    private String reservationTime;
    private String matchingOnOff; // 매칭신청 ON OFF
    private Integer matchingDeposit; //매칭금액
    private String matchingBankName; //매칭 읂ㅇ
    private String matchingBankNumbar; // 매칭시 연락처
    private String matchingVs;
    private String matchingTeamLevel; // 매칭 팀 레벨
    private String matchingTeamName; //팀이름
    private String matchingTeamIntroduction; //팀소개
    private Integer user_suSeq; // 누가 예약하는 사용자 Seq
    private Integer futsalInformation_fiSeq; // 풋살장 정보 Seqs
    private String regDateTime; // 언제 예약하는 시간
    private Integer rpDelMy;
//	---- 사용자 정보
    private String suSeq; //사용자Seq
    private String userName; // 이름
    private String userPhoneNumber; // 폰번호
//	---- 풋살장 정보
    private String fiSeq; // 풋살장 Seq
    private String futsalName; //풋살장 이름
    private String futsalPrice; // 가격
    private String futsalRegion; //지역
    private String futsalAddress; //주소
    private String futsalPhoneNumbar; // 풋살장 번호
//	-----
    


	public String getPaymentKey() {
		return paymentKey;
	}
	public void setPaymentKey(String paymentKey) {
		this.paymentKey = paymentKey;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getFpSeq() {
		return fpSeq;
	}
	public void setFpSeq(String fpSeq) {
		this.fpSeq = fpSeq;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
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
	public Integer getUser_suSeq() {
		return user_suSeq;
	}
	public void setUser_suSeq(Integer integer) {
		this.user_suSeq = integer;
	}
	public Integer getFutsalInformation_fiSeq() {
		return futsalInformation_fiSeq;
	}
	public void setFutsalInformation_fiSeq(Integer integer) {
		this.futsalInformation_fiSeq = integer;
	}
	public String getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
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
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
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
	public String getFutsalPrice() {
		return futsalPrice;
	}
	public void setFutsalPrice(String futsalPrice) {
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
	public Integer getRpDelMy() {
		return rpDelMy;
	}
	public void setRpDelMy(Integer rpDelMy) {
		this.rpDelMy = rpDelMy;
	}

//	----
    
}
