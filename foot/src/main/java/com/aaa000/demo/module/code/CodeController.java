package com.aaa000.demo.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	
	
	@RequestMapping(value = "/code/codeList")
	public String codeList() {
		return "xdm/code/codeXdmList";
	}
}
