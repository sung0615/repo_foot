package com.aaa000.demo.user.review;

public class ReviewDto {

	private String rSeq; //리뷰 Seq
	private Integer starScore; //리뷰 별점
	private String reviewTitle; // 리뷰 제목
	private String reviewText; // 리뷰 내용작성
	private Integer riDelMy; // 리뷰 업데이트 삭제
	private String user_suSeq; //사용자 정보 Seq
	private String futsalInformation_fiSeq; //풋살장정보 Seq
//	-----
	private String suSeq;//사용자 Seq
	private String fiSeq; //풋살장 Seq
//	----
	
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
	public Integer getRiDelMy() {
		return riDelMy;
	}
	public void setRiDelMy(Integer riDelMy) {
		this.riDelMy = riDelMy;
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
	
}
