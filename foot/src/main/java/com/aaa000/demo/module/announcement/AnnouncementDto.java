package com.aaa000.demo.module.announcement;

public class AnnouncementDto {
	
	private String annoSeq;//공지사항 Seq
	private String author;//작성자 이름
	private String creationDate;//작성일 날짜
	private String detail; //공지사항 내용
	private Integer annoDelMy; //업데이트 삭제
	private String title; // 공지사랑 제목
//	-----
	public String getAnnoSeq() {
		return annoSeq;
	}
	public void setAnnoSeq(String annoSeq) {
		this.annoSeq = annoSeq;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getAnnoDelMy() {
		return annoDelMy;
	}
	public void setAnnoDelMy(Integer annoDelMy) {
		this.annoDelMy = annoDelMy;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
