package com.aaa000.demo.user.futsalinformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FutsalinformationController {
	
	@Autowired
	FutsalinformationService futsalinformationService;
	
	// 풋살장 정보 리스트 index 화면 뿌리기
	@RequestMapping(value="/indexUserView")
	public String futsalinformationList(Model model) {
		
		model.addAttribute("list", futsalinformationService.selectList());
		
		return "user/index/indexUserView";
	}
	
	// 풋살장 정보 예약 Reservation 화면 뿌리기
	@RequestMapping(value="/ReservationUserList")
	public String ReservationUserList(Model model) {
			
		model.addAttribute("list", futsalinformationService.selectList());
			
		return "user/reservation/ReservationUserList";
	}
	

}
