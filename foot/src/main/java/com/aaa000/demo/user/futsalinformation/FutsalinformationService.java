package com.aaa000.demo.user.futsalinformation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa000.demo.module.base.BaseService;
import com.amazonaws.services.s3.AmazonS3Client;

@Service
public class FutsalinformationService extends BaseService{
//	for aws.s3 fileupload s
	@Autowired
	private AmazonS3Client amazonS3Client;
	
	@Autowired
	FutsalinformationDao futsalinformationDao;
	
	// 풋살장 정보 리스트 보여주기
	public List<FutsalinformationDto> selectList(FutsalinformationVo vo){
		return futsalinformationDao.selectList(vo);
	}
	
	//풋살자 위도 경도
	public List<FutsalinformationDto> selectList1(){
		return futsalinformationDao.selectList1();
	}
	
	// 풋살장 1개씩 보여주기
	public FutsalinformationDto selectOne(FutsalinformationDto futsalinformationDto) {
		return futsalinformationDao.selectOne(futsalinformationDto);
	}
	
	// 풋살장 등록폼
	public int insert(FutsalinformationDto futsalinformationDto) throws Exception {
		futsalinformationDao.insert(futsalinformationDto);
		
    	uploadFilesToS3(
    			futsalinformationDto.getUploadImg1()
    			, futsalinformationDto
    			, "infrBannerUploaded"
    			, futsalinformationDto.getUploadImg1Type()
    			, futsalinformationDto.getUploadImg1MaxNumber()
    			, futsalinformationDto.getFiSeq()
    			, futsalinformationDao
    			, amazonS3Client);
    	
		return 1;
	}
	
	public int imgUpdate(FutsalinformationDto futsalinformationDto) {
		
		return futsalinformationDao.imgUpdate(futsalinformationDto);
	}
	
	//풋살장 상세에 리뷰 달기
	public int reviewInsert(FutsalinformationDto futsalinformationDto) {
		
		return futsalinformationDao.reviewInsert(futsalinformationDto);
	}
	
	//풋살장 수정하기
	public int update(FutsalinformationDto futsalinformationDto) throws Exception {
		futsalinformationDao.imgUpdate(futsalinformationDto);
		futsalinformationDao.update(futsalinformationDto);
    	uploadFilesToS3(
    			futsalinformationDto.getUploadImg1()
    			, futsalinformationDto
    			, "infrBannerUploaded"
    			, futsalinformationDto.getUploadImg1Type()
    			, futsalinformationDto.getUploadImg1MaxNumber()
    			, futsalinformationDto.getFiSeq()
    			, futsalinformationDao
    			, amazonS3Client);
    	
		return 1;
		
//		return futsalinformationDao.update(futsalinformationDto);
	}
	
	//풋살장 업데이트 삭제
	public int uelete(FutsalinformationDto futsalinformationDto) {
		return futsalinformationDao.uelete(futsalinformationDto);
	}
	
	//페이지 네이션
	public int selectOneCount(FutsalinformationVo vo) {
		return futsalinformationDao.selectOneCount(vo);
	}
	
	// 풋살장 리뷰 리스트 가져오기
	public List<FutsalinformationDto> reviewList(FutsalinformationDto futsalinformationDto){
		return futsalinformationDao.reviewList(futsalinformationDto);
	}


	
	
		
}
