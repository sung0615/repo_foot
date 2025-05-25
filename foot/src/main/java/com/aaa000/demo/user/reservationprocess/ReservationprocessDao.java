package com.aaa000.demo.user.reservationprocess;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ReservationprocessDao {
		
	// 리스트 보여주기
	public List<ReservationprocessDto> selectList(ReservationprocessDto reservationprocessDto);
	
	// 매칭 신청시 매칭 리스트 보여주기
	public List<ReservationprocessDto> matchList();
	
	//매칭 신청시 매칭리스트 상세
	public ReservationprocessDto matchOne(int fpSeq);
	
	// 한데이터만 뽑아을때
	public ReservationprocessDto selectOne(ReservationprocessDto reservationprocessDto);
	
	// 수정하기
	public int update(ReservationprocessDto reservationprocessDto);
	
	// 업데이트 삭제
	public int uelete(List<Long> deleteIds);
	
	// 업데이트 삭제
	public int mauelete(List<Long> deleteIds); 
	
	//예약 리스트 가져오기
	public List<ReservationprocessDto>reservationList(int suSeq);
	
	//매칭 리스트 가져오기
	public List<ReservationprocessDto>MatchList(int suSeq);
	
	//예약 매칭시 업데이트 처리 하기
	public int reservationUpdate(ReservationprocessDto reservationprocessDto);
	
}
