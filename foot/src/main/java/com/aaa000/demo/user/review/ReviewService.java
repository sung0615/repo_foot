package com.aaa000.demo.user.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
	
	@Autowired
	ReviewDao reviewDao;
	
	// 리뷰 리스트 보여주기
	public List<ReviewDto> reviewListByUser(int suSeq){
		return reviewDao.reviewListByUser(suSeq);
	}
	
	// 리뷰 데이터1개씩 뽑기
	public ReviewDto selectOne(ReviewDto reviewDto) {
		return reviewDao.selectOne(reviewDto);
	}
	
	// 리뷰 등록하기
	public int insert(ReviewDto reviewDto) {
		return reviewDao.insert(reviewDto);
	}
	
	// 리뷰 수정하기
	public int update(ReviewDto reviewDto) {
		return reviewDao.update(reviewDto);
	}
	
	// 업데이트 삭제
	public int uelete(List<Long> deleteIds) {
		return reviewDao.uelete(deleteIds);
	}
	
}
