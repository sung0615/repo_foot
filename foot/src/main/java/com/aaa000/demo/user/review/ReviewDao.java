package com.aaa000.demo.user.review;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDao {
	
	// 리뷰 리스트 보여주기
	public List<ReviewDto> selectList();
	
	// 리뷰 1개만 뽑을때
	public ReviewDto selectOne(ReviewDto reviewDto);
	
	// 리뷰 등록폼
	public int insert(ReviewDto reviewDto);
	
	//리뷰 수정하기
	public int update(ReviewDto reviewDto);
	
	// 리뷰 업데이트 삭제
	public int uelete(ReviewDto reviewDto);
}
