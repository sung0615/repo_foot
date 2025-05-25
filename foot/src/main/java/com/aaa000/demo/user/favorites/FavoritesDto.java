package com.aaa000.demo.user.favorites;

import com.aaa000.demo.module.base.BaseDto;

public class FavoritesDto extends BaseDto{
	
	// 즐겨찾기
	private String favoritesSeq; // 즐겨찾기Seq
	private Integer fdelMy; // 업데이트 삭제
	private String futsalInformation_fiSeq; //풋살장 정보Seq
	private String user_suSeq; // 사용자Seq
//	-----	
	private String suSeq;
	private String fiSeq;
//	----
	private boolean isFavorited;
//	----
	private String futsalName; //풋살장 이름
	private Integer futsalPrice; // 풋살장 가격
	private String futsalAddress;
//	----
	
	public String getFavoritesSeq() {
		return favoritesSeq;
	}
	public void setFavoritesSeq(String favoritesSeq) {
		this.favoritesSeq = favoritesSeq;
	}
	public String getFutsalInformation_fiSeq() {
		return futsalInformation_fiSeq;
	}
	public void setFutsalInformation_fiSeq(String futsalInformation_fiSeq) {
		this.futsalInformation_fiSeq = futsalInformation_fiSeq;
	}
	public String getUser_suSeq() {
		return user_suSeq;
	}
	public void setUser_suSeq(String user_suSeq) {
		this.user_suSeq = user_suSeq;
	}
	public Integer getFdelMy() {
		return fdelMy;
	}
	public void setFdelMy(Integer fdelMy) {
		this.fdelMy = fdelMy;
	}
	public String getSuSeq() {
		return suSeq;
	}
	public void setSuSeq(String suSeq) {
		this.suSeq = suSeq;
	}
	public String getFiSeq() {
		return fiSeq;
	}
	public void setFiSeq(String fiSeq) {
		this.fiSeq = fiSeq;
	}
	public boolean isFavorited() {
		return isFavorited;
	}
	public void setFavorited(boolean isFavorited) {
		this.isFavorited = isFavorited;
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
	public String getFutsalAddress() {
		return futsalAddress;
	}
	public void setFutsalAddress(String futsalAddress) {
		this.futsalAddress = futsalAddress;
	}
	

}
