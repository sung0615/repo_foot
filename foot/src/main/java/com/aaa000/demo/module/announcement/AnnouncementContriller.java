package com.aaa000.demo.module.announcement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnouncementContriller {
	
	
	@Autowired
	AnnouncementService announcementService;
	
	//공지사항 리스트 사용자 Ui 공지사항에 List에 뿌리기
	@RequestMapping(value="/AnnouncementUserList")
	public String AnnouncementUserList(Model model, AnnouncementVo vo) {
		vo.setParamsPaging(announcementService.selectOneCount(vo));
		model.addAttribute("list", announcementService.selectList(vo));
		model.addAttribute("vo", vo);
		return "user/announcement/AnnouncementUserList";
	}
	
	// 공지사항 상세 사용자Ui 공지사항 상세 눌렀을때 뿌리기
	@RequestMapping(value="/AnnouncementUserView")
	public String AnnouncementUserView(Model model, AnnouncementDto announcementDto) {
		model.addAttribute("item", announcementService.selectOne(announcementDto));
		return "user/announcement/AnnouncementUserView";
	}
	
	
	
	
	
	//공지사항 리스트 관리자 에 뿌려주기
	@RequestMapping(value = "/AnnouncementXdmList")
	public String AnnouncementList(AnnouncementVo vo, Model model) {
		vo.setParamsPaging(announcementService.selectOneCount(vo));
		model.addAttribute("list", announcementService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/announcement/AnnouncementXdmList";
	}
	
	
	
	//공지사항 관리자 에서 공지사항 등록 하기
	@RequestMapping(value ="/AnnouncementXdmForm")
	public String AnnouncementForm(Model model, AnnouncementDto announcementDto) {
		
		
		return "xdm/announcement/AnnouncementXdmForm";
	}
	//등록후 관리자 리스트에 보여주리
	@RequestMapping(value="/AnnouncementInst")
	public String AnnouncementInst(AnnouncementDto announcementDto) {
		
		announcementService.insert(announcementDto);
		
		return "redirect:/AnnouncementXdmList";
	}
	
	//등록한 공지사항 데이터 1개 뽑아서 1개 보여주기
	@RequestMapping(value="/AnnouncementXdmMfom")
	public String AnnouncementMfom(Model model,AnnouncementDto announcementDto) {
		model.addAttribute("item", announcementService.selectOne(announcementDto));
		return "xdm/announcement/AnnouncementXdmMfom";
	}
	//수정한 데이터를 리스트에 화면으로 옴겨야됨
	@RequestMapping(value="/AnnouncementUpdt")
	public String AnnouncementUpdt (AnnouncementDto announcementDto) {
		
		announcementService.update(announcementDto);
		
		return "redirect:/AnnouncementXdmList";
	}
	
	
	//업데이트 삭제
	@RequestMapping(value="/AnnouncementUele")
	public String AnnouncementUele (AnnouncementDto announcementDto) {
		announcementService.uelete(announcementDto);
		return "redirect:/AnnouncementXdmList";
	}
	
	
	
	
}
