package com.aaa000.demo.user.futsalinformation;

import java.util.List;

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
	public String futsalinformationList(Model model, FutsalinformationVo vo) {
		
		model.addAttribute("list", futsalinformationService.selectList(vo));
		
		return "user/index/indexUserView";
	}
	

	
	// 풋살장 정보 예약 Reservation 화면 뿌리기
	@RequestMapping(value="/ReservationUserList")
	public String ReservationUserList(Model model, FutsalinformationVo vo, FutsalinformationDto futsalinformationDto) {
		

	   
		


		
		vo.setParamsPaging(futsalinformationService.selectOneCount(vo));
		
	
		
		model.addAttribute("list", futsalinformationService.selectList(vo));
		model.addAttribute("vo", vo);
			
		return "user/reservation/ReservationUserList";
	}
	
	
	
	
	//풋살장 리스트 관리자 리스에뿌리기
	@RequestMapping(value="/FutsalXdmList")
	public String FutsalXdmList(Model model, FutsalinformationVo vo) {
		
		vo.setParamsPaging(futsalinformationService.selectOneCount(vo));
		model.addAttribute("list", futsalinformationService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/futsal/FutsalXdmList";
	}
	
	// 풋살장 관리자 등록 폼 만들기 만들기
	@RequestMapping(value="/FutsalXdmForm")
	public String FutsalXdmForm() {
		
		
		
		return "xdm/futsal/FutsalXdmForm";
	}
	//풋살장 등록후 풋살장 리스트에 뿌리기
	@RequestMapping(value="/FutsalInst")
	public String FutsalInst(FutsalinformationDto futsalinformationDto) throws Exception {
		
		
		
		
		futsalinformationService.insert(futsalinformationDto);
		return "redirect:/FutsalXdmList";
		
	}
	
	
	//풋살장 정보 관리자에서 수정폼 Mfom
	@RequestMapping(value="/FutsalXdmMfom")
	public String FutsalXdmMfom(Model model,FutsalinformationDto futsalinformationDto) {
		model.addAttribute("item", futsalinformationService.selectOne(futsalinformationDto));
		return "xdm/futsal/FutsalXdmMfom";
	}
	//수정한 데이터를 리스트 화면으로 옴겨야됨
	@RequestMapping(value="/FutsalUpdt")
	public String FutsalUpdt (FutsalinformationDto futsalinformationDto) {
		futsalinformationService.update(futsalinformationDto);
		return "redirect:/FutsalXdmList";
	}
	
	
	
	//업데이트 삭제
	@RequestMapping(value="/FutsalUele")
	public String FutsalUele (FutsalinformationDto futsalinformationDto) {
		futsalinformationService.uelete(futsalinformationDto);
		return "redirect:/FutsalXdmList";
	}
	
	
	
	
	
	// 풋살장 상세 페이지
	@RequestMapping(value = "/DetailedPageUserForm")
	public String DetailedPageUserForm(Model model, FutsalinformationVo vo, FutsalinformationDto futsalinformationDto) {

	    // 리뷰 목록을 가져옴
	    List<FutsalinformationDto> reviewList = futsalinformationService.reviewList(futsalinformationDto);

	    // 총 리뷰 개수 계산
	    int totalReviews = reviewList.size();

	    // 각 별점별 비율 계산 (1 ~ 5점)
	    int[] ratingCounts = new int[5]; // 별점 1 ~ 5의 개수
	    for (FutsalinformationDto review : reviewList) {
	        int starScore = review.getStarScore();
	        if (starScore >= 1 && starScore <= 5) {
	            ratingCounts[starScore - 1]++;
	        }
	    }

	    // 각 별점 비율 계산
	    double[] ratingPercentages = new double[5];
	    for (int i = 0; i < 5; i++) {
	        ratingPercentages[i] = (totalReviews > 0) ? (double) ratingCounts[i] / totalReviews * 100 : 0.0;
	    }

	    // 평균 별점 계산 (리뷰가 있을 때만 계산)
	    double averageRating = 0.0;
	    if (totalReviews > 0) {
	        double totalRating = 0.0;
	        for (FutsalinformationDto review : reviewList) {
	            totalRating += review.getStarScore(); // 각 리뷰의 별점 점수를 더함
	        }
	        averageRating = totalRating / totalReviews; // 평균 별점 계산
	    }

	    // 모델에 값 추가
	    model.addAttribute("averageRating", averageRating); // 평균 별점
	    model.addAttribute("ratingPercentages", ratingPercentages); // 별점별 비율
	    model.addAttribute("reviewList", reviewList); // 리뷰 목록
	    model.addAttribute("item", futsalinformationService.selectOne(futsalinformationDto)); // 풋살장 정보

	    return "user/detailedpage/DetailedPageUserForm";
	}

	

	
	

	
	

}
