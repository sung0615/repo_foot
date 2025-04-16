package com.aaa000.demo.user.reservationprocess;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa000.demo.user.futsalinformation.FutsalinformationDto;
import com.aaa000.demo.user.futsalinformation.FutsalinformationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReservationprocessController {
	
	@Autowired
	ReservationprocessService reservationprocessService;
	
	@Autowired
	FutsalinformationService futsalinformationService;
	
	
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
	
	
	
	//풋살장 예약 정보 아작스 담기
	@ResponseBody
	@RequestMapping(value = "/DetailedPageUser")
	public Map<String, Object> DetailedPageUser(ReservationprocessDto reservationprocessDto, HttpSession session) throws Exception {
	    Map<String, Object> returnMap = new HashMap<>();
	    
	    //풋살장 정보 Seq 담아오기
	    String rtt =  reservationprocessDto.getFiSeq();
	    
	    // 세션에 저장
	    session.setAttribute("reservationData", reservationprocessDto);
	 
	    
	    returnMap.put("result", rtt);
	    
	    return returnMap;
	}
	
	
	
	// 풋살장 예약 결제 했을때 인덱스 화면으로 가라
	@RequestMapping("/PayUserForm")
	public String PayUserForm(HttpSession session, Model model,FutsalinformationDto futsalinformationDto) {
		
	    // 세션에서 예약 정보 꺼내기
	    ReservationprocessDto reservationData = (ReservationprocessDto) session.getAttribute("reservationData");
	    FutsalinformationDto futsalInfoData = (FutsalinformationDto) session.getAttribute("futsalInfoData");
		
	    
	    // 필요한 정보 모델에 담기
	    model.addAttribute("reservationData", reservationData);
	    model.addAttribute("futsalInfoData", futsalInfoData);
	    
	    

	    model.addAttribute("item", futsalinformationService.selectOne(futsalinformationDto));
	  
	   
	    
	    return "user/pay/PayUserForm"; // 실제 JSP 경로
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
