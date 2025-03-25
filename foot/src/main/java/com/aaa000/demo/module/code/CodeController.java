package com.aaa000.demo.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaa000.demo.module.codegroup.CodeGroupService;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	

	 
	 
	
	// 리스트 보여주고 페이지네이션 보여주기
	@RequestMapping(value = "/code/codeList")
	public String codeList(CodeVo vo, Model model) {
		
		vo.setParamsPaging(codeService.selectOneCount(vo));
		model.addAttribute("list", codeService.selectList(vo));
		model.addAttribute("vo",vo);
		
		
		
		return "xdm/code/codeXdmList";
	}
	
	
	// 등록폼
	@RequestMapping(value="/code/CodeForm")
	public String CodeForm(CodeDto codeDto, Model model) {
		model.addAttribute("list", codeService.codeGroupNameSeq(codeDto));
		
		return "xdm/code/CodeXdmForm";
	}
	
	// 등록후 리스트 에서 보여주라
	@RequestMapping(value="/code/CodeInst")
	public String CodeInst(CodeDto codeDto) {
		codeService.insert(codeDto);
		return "redirect:/code/codeList";
	}
	
	// 업데이트 삭제
	@RequestMapping(value="/code/CodeUele")
	public String CodeUele(CodeDto codeDto) {
		codeService.uelete(codeDto);
		return "redirect:/code/codeXdmList";
	}
	
	
	//데이터 1개씩 뽑아서 폼 화면 뿌리기
	@RequestMapping(value="/code/CodeView")
	public String CodeView(Model model,CodeDto codeDto) {
		
		model.addAttribute("item", codeService.selectOne(codeDto));
		
		return"xdm/code/CodeXdmForm";
	}
	
		
	
	
		
		
		
}
