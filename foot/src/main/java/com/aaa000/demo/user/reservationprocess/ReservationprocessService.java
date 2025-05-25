package com.aaa000.demo.user.reservationprocess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa000.demo.module.base.BaseService;

@Service
public class ReservationprocessService extends BaseService {
	
	@Autowired
	ReservationprocessDao reservationprocessDao;
	
	// 리스트 보여주기
	public List<ReservationprocessDto> selectList(ReservationprocessDto reservationprocessDto){
		return reservationprocessDao.selectList(reservationprocessDto);
	}
	
	//매칭 신청시 리스트 보여주기
	public List<ReservationprocessDto> matchList(){
		return reservationprocessDao.matchList();
	}
	
	//매칭 신청 리스트 상세
	public ReservationprocessDto matchOne(int fpSeq) {
		return reservationprocessDao.matchOne(fpSeq);
	}
	
	// 한개씩 뽑기
	public ReservationprocessDto selectOne(ReservationprocessDto reservationprocessDto) {
		return reservationprocessDao.selectOne(reservationprocessDto);
	}
	

	
	
	// 수정하기
	public int update(ReservationprocessDto reservationprocessDto) {
		return reservationprocessDao.update(reservationprocessDto);
	}
	
	//업데이트 삭제
	public int uelete(List<Long> deleteIds) {
		return reservationprocessDao.uelete(deleteIds);
	}
	// 예약 리스트 보여주기
	public List<ReservationprocessDto> reservationList(int suSeq){
		return reservationprocessDao.reservationList(suSeq);
	}
	
}
