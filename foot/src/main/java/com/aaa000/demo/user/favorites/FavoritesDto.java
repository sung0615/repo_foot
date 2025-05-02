package com.aaa000.demo.user.favorites;

public class FavoritesDto {
	
	// 즐겨찾기
	private String favoritesSeq; // 즐겨찾기Seq
	private Integer fdelMy; // 업데이트 삭제
	private String futsalInformation_fiSeq; //풋살장 정보Seq
	private String user_suSeq; // 사용자Seq
//	-----	
	 
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
	

}
