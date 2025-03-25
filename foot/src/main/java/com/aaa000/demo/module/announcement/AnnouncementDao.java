package com.aaa000.demo.module.announcement;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementDao {
	
	//리스트 보여주기
	public List<AnnouncementDto> selectList(AnnouncementVo vo);
	
	//등록하기
	public int insert(AnnouncementDto announcementDto);
	
	
	//수정폼 업데이트
	public int update(AnnouncementDto announcementDto);
	
	
	// 데이터 하나씩 뽑기 보여주기
	public AnnouncementDto selectOne(AnnouncementDto announcementDto);
	
	
	//업데이트 삭제
	public int uelete(AnnouncementDto announcementDto);
	
	
	//페이지 네이션
	public int selectOneCount(AnnouncementVo vo);
	
	
}
