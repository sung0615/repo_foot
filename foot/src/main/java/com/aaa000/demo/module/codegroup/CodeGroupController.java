package com.aaa000.demo.module.codegroup;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aaa000.demo.common.util.UtilDateTiem;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	
	//리스트 보여주고 
	@RequestMapping(value = "/codeGroup/codeGroupXdmList")
	public String codeGroupXdmList(CodeGroupVo vo,Model model,CodeGroupDto  codeGroupDto, HttpServletResponse httpServletResponse) {
		// 토탈 가져와야되는 값이 먼저 돌아야된다
		// 본데이터 값이 그다음 돌아야된다
		
		
		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		model.addAttribute("list", codeGroupService.selectList(vo));
		model.addAttribute("vo", vo);
		
		
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTiem.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTiem.add59TimeString(vo.getShDateEnd()));
		
		
		
		

		return "xdm/codeGroup/codeGroupXdmList";
	}
	
	// 등록하기
	@RequestMapping(value = "/codeGroup/codeGroupXdmForm")
	public String codeGroupXdmForm(@ModelAttribute("vo") CodeGroupVo vo,Model model) {
		
		
		if(vo.getCdgSeq().equals("0") || vo.getCdgSeq().equals("")) {
	//		insert mode
		} else {
	//		update mode
			model.addAttribute("item", codeGroupService.selectOne(vo));
			
			
			
		}
		
		return "xdm/codeGroup/codeGroupXdmForm";
	}
	// 등록후 리스트 에서 보여주라
	@RequestMapping(value ="/codeGroup/codeGroupInst")
	public String codeGroupInst(CodeGroupDto codeGroupDto) {
		
		
		codeGroupService.insert(codeGroupDto);
		return "redirect:/codeGroup/codeGroupXdmList";
	}
	
	
	
	// 업데이트
	@RequestMapping(value ="/codeGroup/codeGroupUpdt")
	public String codeGroupUpdt(CodeGroupDto codeGroupDto) {
		codeGroupService.update(codeGroupDto);
		return "redirect:/codeGroup/codeGroupXdmList";
		
	}
	
	
	//업데이트 삭제
	@RequestMapping(value ="/codeGroup/codeGroupUele")
	public String codeGroupUele(CodeGroupDto codeGroupDto) {
		codeGroupService.uelete(codeGroupDto);
		return "redirect:/codeGroup/codeGroupXdmList";
	}
	
	
	//파일 업로드
	@RequestMapping(value = "/readExcel")
	public String readExcel(CodeGroupDto codeGroupDto,@RequestParam("file") MultipartFile file) throws Exception { 

		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		
		for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
			CodeGroupDto excel = new CodeGroupDto();
		       
		    
		    DataFormatter formatter = new DataFormatter();		        
		    XSSFRow row = worksheet.getRow(i);
		    	    	

		    String seq = formatter.formatCellValue(row.getCell(0));
		    String name = formatter.formatCellValue(row.getCell(1));
		    String delNy = formatter.formatCellValue(row.getCell(2));

		
			if (delNy.equals("N")) {
				delNy = "0";
			} else {
				delNy = "1";
			}

			excel.setCdgSeq(seq);

			excel.setIfcgName(name);

			excel.setIfchDelNy(Integer.parseInt(delNy));

	
	        codeGroupService.insert1(excel);
		} 
		
		return "redirect:/codeGroup/codeGroupXdmList";
	}
	
	
	

	
}
