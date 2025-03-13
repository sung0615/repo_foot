package com.aaa000.demo.module.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;



@Repository
public interface CodeGroupDao {
	
	// 전체 보여주기
	public List<CodeGroupDto> selectList();
	
	// 등록 하기
	public int insert(CodeGroupDto codeGroupDto);
	
	//업데이트 삭제
	public int uelete(CodeGroupDto codeGroupDto);
	

}
