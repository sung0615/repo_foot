package com.aaa000.demo.user.futsalinformation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FutsalinformationService {
	
	@Autowired
	FutsalinformationDao futsalinformationDao;
	
	// 풋살장 정보 리스트 보여주기
	public List<FutsalinformationDto> selectList(){
		return futsalinformationDao.selectList();
	}
	
	// 풋살장 1개씩 보여주기
	public FutsalinformationDto selectOne(FutsalinformationDto futsalinformationDto) {
		return futsalinformationDao.selectOne(futsalinformationDto);
	}
	
	// 풋살장 등록폼
	public int insert(FutsalinformationDto futsalinformationDto) {
		return futsalinformationDao.insert(futsalinformationDto);
	}
	
	//풋살장 수정하기
	public int update(FutsalinformationDto futsalinformationDto) {
		return futsalinformationDao.update(futsalinformationDto);
	}
	
	//풋살장 업데이트 삭제
	public int uelete(FutsalinformationDto futsalinformationDto) {
		return futsalinformationDao.uelete(futsalinformationDto);
	}
	
	
}
