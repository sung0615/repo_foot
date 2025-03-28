package com.aaa000.demo.module.code;

import java.util.ArrayList;
import java.util.List;

public class CodeDto {
	
	private String cdSeq; // 코드Seq
	private String ifcdName; //코드 이름
	private Integer ifcdDelNy; //업데이트 삭제
	private String newsAgencyName; //통신사 이름
	private String codeGroup_cdgSeq; //코드구릅Seq
	private String ifcgName; // 코드 그룹 이름
	private String cdgSeq;// 코드 그룹 Seq;
//	-----
//	for cache
	
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	
	
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
	public Integer getIfcdDelNy() {
		return ifcdDelNy;
	}
	public void setIfcdDelNy(Integer ifcdDelNy) {
		this.ifcdDelNy = ifcdDelNy;
	}
	public String getNewsAgencyName() {
		return newsAgencyName;
	}
	public void setNewsAgencyName(String newsAgencyName) {
		this.newsAgencyName = newsAgencyName;
	}
	public String getCodeGroup_cdgSeq() {
		return codeGroup_cdgSeq;
	}
	public void setCodeGroup_cdgSeq(String codeGroup_cdgSeq) {
		this.codeGroup_cdgSeq = codeGroup_cdgSeq;
	}
	

//	----
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	public String getCdgSeq() {
		return cdgSeq;
	}
	public void setCdgSeq(String cdgSeq) {
		this.cdgSeq = cdgSeq;
	}
	
	
}
