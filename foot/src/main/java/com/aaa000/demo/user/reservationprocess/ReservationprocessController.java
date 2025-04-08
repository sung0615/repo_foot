package com.aaa000.demo.user.reservationprocess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationprocessController {
	
	@Autowired
	ReservationprocessService reservationprocessService;
	// 매칭신청시  my페이지 상세에 소셜매칭 신청내역 List 뿌리기
	@RequestMapping(value="/SocialMatchDetailsUserList")
	public String SocialMatchDetailsUserList() {
		
		return "user/socialmatchdetails/SocialMatchDetailsUserList";
	}
	
	
	// 풋살장 예약내역 my페이지 상세에 예약내역에 뿌리기
	@RequestMapping(value="/ReservationDetailsUserList")
	public String ReservationDetailsUserList() {
		
		return "user/reservationdetails/ReservationDetailsUserList";
	}
	
	
	
	
	// 풋살장 예약에서 매칭 리스트  화면 뿌리기
	@RequestMapping(value="/SocialMatchUserList")
	public String SocialMatchList() {		
			
		return "user/socialMatch/SocialMatchUserList";
	}
	
	
	
	
	
	
	
	// 풋살장 예약 결제 했을때 인덱스 화면으로 가라
	@RequestMapping(value="/PayUserForm")
	public String PayUserForm() {
		return "user/pay/PayUserForm";
	}
	@RequestMapping(value="/PayUserInst")
	public String PayUserInst(ReservationprocessDto reservationprocessDto) {
		reservationprocessService.insert(reservationprocessDto);
		return "redirect:/user/socialMatch/SocialMatchUserList";
	}
	
	
	
	
	// 풋살 매칭 신청 폼 등록하기 매칭신청했으면 매칭 리스트로 가라
	@RequestMapping(value="/SocialMatchBookingUserForm")
	public String SocialMatchBookingUserForm() {
		return "user/socialmatchbooking/SocialMatchBookingUserForm";
	}
	@RequestMapping(value="/SocialMatchBookingUserInst")
	public String SocialMatchBookingUserInst(ReservationprocessDto reservationprocessDto) {
		reservationprocessService.insert(reservationprocessDto);
		return "redirect:/user/socialMatch/SocialMatchUserList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
