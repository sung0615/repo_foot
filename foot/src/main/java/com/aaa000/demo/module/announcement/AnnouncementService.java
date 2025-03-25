package com.aaa000.demo.module.announcement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementService {
	
	
	@Autowired
	AnnouncementDao announcementDao;
	
	//리스트 보여주기
	public List<AnnouncementDto> selectList(AnnouncementVo vo){
		return announcementDao.selectList(vo);
	}
	
	// 데이터 1개씩 뽑는거
	public AnnouncementDto selectOne(AnnouncementDto announcementDto) {
		return announcementDao.selectOne(announcementDto);
	}
	//등록폼
	public int insert(AnnouncementDto announcementDto) {
		return announcementDao.insert(announcementDto);
	}
	
	//업데이트
	public int update(AnnouncementDto announcementDto) {
		return announcementDao.update(announcementDto);
	}
	
	//업데이트 삭제
	public int uelete(AnnouncementDto announcementDto) {
		return announcementDao.uelete(announcementDto);
	}
	
	//페이지 네이션
	public int selectOneCount(AnnouncementVo vo) {
		return announcementDao.selectOneCount(vo);
	}
}
