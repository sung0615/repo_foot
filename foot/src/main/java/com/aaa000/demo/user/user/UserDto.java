package com.aaa000.demo.user.user;

public class UserDto {
	
	private String suSeq; //사용자 Seq
	private String userName; //사용자 이름
	private String userGender; // 사용자 성별
	private String userNewsAgency; //사용자 통신사
	private String userPhoneNumber; //사용자 폰번호
	private String userBirthday; //사용자 생일
	private String userId; //사용자 id
	private String userEmail; // 사용자 이메일
	private String userPassword; //사용자 페스워드
	private Integer uDelMy; // 데이터 삭제
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
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserNewsAgency() {
		return userNewsAgency;
	}
	public void setUserNewsAgency(String userNewsAgency) {
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
//	----

}
