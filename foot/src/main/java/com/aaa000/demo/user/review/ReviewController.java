package com.aaa000.demo.user.review;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	

	
}
