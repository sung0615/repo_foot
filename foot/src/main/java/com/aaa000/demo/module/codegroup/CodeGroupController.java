package com.aaa000.demo.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	
	//리스트 보여주고 
	@RequestMapping(value = "/codeGroup/codeGroupList")
	public String codeGroupList(CodeGroupVo vo,Model model,CodeGroupDto  codeGroupDto) {
		// 토탈 가져와야되는 값이 먼저 돌아야된다
		// 본데이터 값이 그다음 돌아야된다
		
		
		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		model.addAttribute("list", codeGroupService.selectList(vo));
		model.addAttribute("vo", vo);
		
		
		

		return "xdm/codeGroup/codeGroupXdmList";
	}
	
	// 등록하기
	@RequestMapping(value = "/codeGroup/codeGroupForm")
	public String codeGroupForm() {
		
		
		return "xdm/codeGroup/codeGroupXdmForm";
	}
	// 등록후 리스트 에서 보여주라
	@RequestMapping(value ="/codeGroup/codeGroupInst")
	public String codeGroupInst(CodeGroupDto codeGroupDto) {
		
		
		codeGroupService.insert(codeGroupDto);
		return "redirect:/codeGroup/codeGroupList";
	}
	
	//업데이트 삭제
	@RequestMapping(value ="/codeGroup/codeGroupUele")
	public String codeGroupUele(CodeGroupDto codeGroupDto) {
		codeGroupService.uelete(codeGroupDto);
		return "redirect:/codeGroup/codeGroupList";
	}
	
	

	
}
