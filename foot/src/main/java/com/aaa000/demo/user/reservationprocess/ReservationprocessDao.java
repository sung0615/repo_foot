package com.aaa000.demo.user.reservationprocess;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ReservationprocessDao {
		
	// 리스트 보여주기
	public List<ReservationprocessDto> selectList(ReservationprocessDto reservationprocessDto);
	
	// 한데이터만 뽑아을때
	public ReservationprocessDto selectOne(ReservationprocessDto reservationprocessDto);
	
	// 등록폼
	public int insert(ReservationprocessDto reservationprocessDto);
	
	// 수정하기
	public int update(ReservationprocessDto reservationprocessDto);
	
	// 업데이트 삭제
	public int uelete(ReservationprocessDto reservationprocessDto); 
	
}
