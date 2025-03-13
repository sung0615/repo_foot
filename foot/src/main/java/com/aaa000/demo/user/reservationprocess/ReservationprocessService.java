package com.aaa000.demo.user.reservationprocess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationprocessService {
	
	@Autowired
	ReservationprocessDao reservationprocessDao;
	
	// 리스트 보여주기
	public List<ReservationprocessDto> selectList(){
		return reservationprocessDao.selectList();
	}
	
	// 한개씩 뽑기
	public ReservationprocessDto selectOne(ReservationprocessDto reservationprocessDto) {
		return reservationprocessDao.selectOne(reservationprocessDto);
	}
	
	// 등록하기
	public int insert(ReservationprocessDto reservationprocessDto) {
		return reservationprocessDao.insert(reservationprocessDto);
	}
	
	
	// 수정하기
	public int update(ReservationprocessDto reservationprocessDto) {
		return reservationprocessDao.update(reservationprocessDto);
	}
	
	//업데이트 삭제
	public int uelete(ReservationprocessDto reservationprocessDto) {
		return reservationprocessDao.uelete(reservationprocessDto);
	}
}
