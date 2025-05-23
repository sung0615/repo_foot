package com.aaa000.demo.user.review;

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

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {
		
	
	@Autowired
	ReviewService reviewService;
	
	
    // 리뷰 저장 메소드
//    @PostMapping("/reviewUdate")
//    @ResponseBody
//    public String reviewUdate(ReviewDto reviewDto) {
//        // 서버에서 받은 reviewDto 확인
//        System.out.println("유저 번호: " + reviewDto.getUser_suSeq());
//        
//        // 리뷰 저장 로직
//        reviewService.insert(reviewDto);
//        
//        // 성공 메시지 반환
//        return "success";
//    }
	
	// 리뷰 업데이트
	@ResponseBody
	@RequestMapping(value = "/reviewUdate")
	public Map<String, Object> reviewUdate(ReviewDto reviewDto, HttpSession httpSession) throws Exception {
	    
	    Map<String, Object> returnMap = new HashMap<>();
	    
	    // 리뷰 저장
	    reviewService.insert(reviewDto);
	    
	    // 성공 메시지 추가
	    returnMap.put("status", "success");
	    
	    return returnMap;
	}

	
    // 사용자 리뷰 리스트 보여주기
    @RequestMapping("/ReviewUserList")
    public String ReviewUserList(HttpSession session, Model model) {

        // 세션에서 로그인한 사용자 suSeq 꺼내기
    	String suSeqStr = (String) session.getAttribute("sessSeqUser");

        
    	int suSeq = Integer.parseInt(suSeqStr);  // 문자열을 정수로 변환
        // 해당 사용자 리뷰 리스트 가져오기
        List<ReviewDto> reviewList = reviewService.reviewListByUser(suSeq);

        // 모델에 리스트 담아서 뷰로 전달
        model.addAttribute("list", reviewList);

        return "user/review/ReviewUserList"; // JSP or Thymeleaf 경로에 맞게 수정
    }
	
	// 리뷰 업데이트 삭제
    @PostMapping("/ReviewUserUele")
    public String ReviewUserUele(@RequestParam("deleteIds") List<Long> deleteIds) {
        reviewService.uelete(deleteIds);  // 
        return "redirect:/ReviewUserList";
    }
	
	

	
}
