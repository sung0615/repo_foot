package com.aaa000.demo.user.reservationprocess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String SocialMatchDetailsUserList(Model model,HttpSession session) {
		
		// 세션에서 로그인한 사용자 suSeq 꺼내기
    	String suSeqStr = (String) session.getAttribute("sessSeqUser");
    	
    	int suSeq = Integer.parseInt(suSeqStr);
    	// 해당 사용자 예약 리스트 가져오기
    	List<ReservationprocessDto> reList =  reservationprocessService.MatchList(suSeq);
		
		model.addAttribute("list", reList);
		
		return "user/socialmatchdetails/SocialMatchDetailsUserList";
	}
	
	
	// 풋살장 예약내역 my페이지 상세에 예약내역에 뿌리기
	@RequestMapping(value="/ReservationDetailsUserList")
	public String ReservationDetailsUserList(Model model,HttpSession session) {
		
		// 세션에서 로그인한 사용자 suSeq 꺼내기
    	String suSeqStr = (String) session.getAttribute("sessSeqUser");
    	
    	int suSeq = Integer.parseInt(suSeqStr);
    	// 해당 사용자 예약 리스트 가져오기
    	List<ReservationprocessDto> reList =  reservationprocessService.reservationList(suSeq);
		
		model.addAttribute("list", reList);
		return "user/reservationdetails/ReservationDetailsUserList";
	}
	
	
	
	
	// 풋살장 예약에서 매칭 리스트  화면 뿌리기
	@RequestMapping(value="/SocialMatchUserList")
	public String SocialMatchList(Model model) {		
		
		
		model.addAttribute("list", reservationprocessService.matchList());
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

	

	
	
	
	
	// 풋살 매칭 신청 폼 등록하기 매칭신청했으면 매칭 리스트로 가라
	@RequestMapping(value="/SocialMatchBookingUserForm")
	public String SocialMatchBookingUserForm(@RequestParam(value = "fpSeq", required = false) Integer fpSeq,Model model) {
		
		model.addAttribute("item", reservationprocessService.matchOne(fpSeq));
		
		return "user/socialmatchbooking/SocialMatchBookingUserForm";
	}

	
	
	// 예약 내역 업데이트 삭제
    @PostMapping("/ReservationUserUele")
    public String ReservationUserUele(@RequestParam("deleteIds") List<Long> deleteIds) {
    	reservationprocessService.uelete(deleteIds);  // 
        return "redirect:/ReservationDetailsUserList";
    }
    
	// 예약 내역 업데이트 삭제
    @PostMapping("/maUserUele")
    public String maUserUele(@RequestParam("deleteIds") List<Long> deleteIds) {
    	reservationprocessService.mauelete(deleteIds);  // 
        return "redirect:/ReservationDetailsUserList";
    }
	
	
    // 풋살장 매칭 신청 업데이트처리
    @RequestMapping(value="reservationUpdate")
    public String reservationUpdate(ReservationprocessDto reservationprocessDto,HttpSession session) {
    	
        // 세션에서 사용자 식별자 꺼내기
        Object sessSeqUser = session.getAttribute("sessSeqUser");
    
    	
    	reservationprocessService.reservationUpdate(reservationprocessDto);
    	return "redirect:/SocialMatchDetailsUserList";
    }


	
	
	
	
	
	
	
	
	
	
}
