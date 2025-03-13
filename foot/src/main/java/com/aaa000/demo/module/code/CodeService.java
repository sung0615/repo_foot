package com.aaa000.demo.module.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codedao;
	
	public List<CodeDto> selectList(){	
		return codedao.selectList();
	}
}
