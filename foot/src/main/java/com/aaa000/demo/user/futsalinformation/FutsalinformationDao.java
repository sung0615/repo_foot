package com.aaa000.demo.user.futsalinformation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aaa000.demo.module.base.BaseDao;
import com.aaa000.demo.module.base.BaseDto;

@Repository
public interface FutsalinformationDao extends BaseDao{
	
	// 풋살장 정보 리스트					
	public List<FutsalinformationDto> selectList(FutsalinformationVo vo);
	
	public List<FutsalinformationDto> selectList1();
	
	//정보 1개씩 뽑기
	public FutsalinformationDto selectOne(FutsalinformationDto futsalinformationDto);
	
	// 풋살장 등록폼
	public int insert(FutsalinformationDto futsalinformationDto);
	
	// 풋살장 수정폼
	public int update(FutsalinformationDto futsalinformationDto);
	
	//이미지 수정
	public int imgUpdate(FutsalinformationDto futsalinformationDto);
	
	// 풋살장 정보 업데이트 삭제
	public int uelete(FutsalinformationDto futsalinformationDto);
	
	public int selectOneCount(FutsalinformationVo vo);
	
	// 풋살장 들록폼 리뷰 등록
	public int reviewInsert (FutsalinformationDto futsalinformationDto);
	
	
	// 풋살장 리뷰 리스트 가져오기
	public List <FutsalinformationDto> reviewList(FutsalinformationDto futsalinformationDto);
	
	public int insertUploaded(BaseDto Dto);
	
	// 이미지 수정
	public int imgupdate(FutsalinformationDto futsalinformationDto);
	
	
	
}
