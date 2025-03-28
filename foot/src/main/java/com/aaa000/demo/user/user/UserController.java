package com.aaa000.demo.user.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa000.demo.module.code.CodeVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	// 사용자 회원 가입 리스트 관리자에서 보여주기
	@RequestMapping(value="/UserMemberList")
	public String UserMember(Model model, UserVo vo) {
		
		
		vo.setParamsPaging(userService.selectOneCount(vo));
		model.addAttribute("list", userService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/usermember/UserMemberList";
	}
	
	
	
	
	
	// 사용자 회원가입하기 등록폼 하기 (회원가입 후 로그인 주소로 가겠끔 수정해야함)
	@RequestMapping(value="/SignupUserForm")
	public String SignupUserForm(Model model,UserDto userDto, CodeVo vo) {
		
		model.addAttribute("list", userService.codeList(userDto));
		model.addAttribute("item", userService.selectOne(userDto));
		
		
		return "user/signup/SignupUserForm";
	}
	@RequestMapping(value="/SignupUserInst")
	public String SignupUserInst(UserDto userDto) {
		userService.insert(userDto);
								// 회원 가입이 됬을때 로그인창으로 넘경됨
		return "redirect:/SigninUser";
	}
	
	
	
	
	// 회원 정보 관리자 Ui 상세 뿌리기
	@RequestMapping(value="/UserMemberView")
	public String UserMemberView(Model model,UserDto userDto) {
		
		model.addAttribute("item", userService.selectOne(userDto));
		return "/xdm/usermember/UserMemberView";
	}
	
	
	
	
	// 유저 가입 가입 헀던거 수정하기 my페이지 안에 보여주고 수정하기
	@RequestMapping(value = "/AccountSettingsUserMfom")
	public String AccountSettingsUserMfom(Model model,UserDto userDto) {
		model.addAttribute("item", userService.selectOne(userDto));
		return "/user/accountsettings/AccountSettingsUserMfom";
	}
	//수정한 데이터를 수정하고 my페이지 정보수정페이지  찾아라
	@RequestMapping(value="/AccountSettingsUserUpdt")
	public String AccountSettingsUserUpdt(UserDto userDto) {
		userService.update(userDto);
		return "redirect:/user/accountsettings/AccountSettingsUserMfom";
	}
	
	
	
	// 유저 가입 가입 헀던거 비밀번호 수정하기 my페이지 안에 보여주고 수정하기
	@RequestMapping(value="/PasswordChangeUserMfom")
	public String PasswordChangeUserMfom(Model model,UserDto userDto) {
		model.addAttribute("item", userService.selectOne(userDto));
		return "/user/passwordchange/PasswordChangeUserMfom";
	}
	// 수정한 데이터 수정하고 my페이지 비밀번호 수정페이지를 찾아라
	@RequestMapping(value="/PasswordChangeUserUpdt")
	public String PasswordChangeUserUpdt(UserDto userDto) {
		userService.update(userDto);
		return "redirect:/user/passwordchange/PasswordChangeUserMfom";
	}
	
	
	// 사용자 업데이트 삭제
	@RequestMapping(value="/SecessionUserUele")
	public String SecessionUserUele(UserDto userDto) {
		userService.uelete(userDto);
		return "/user/secession/SecessionUserUele";
	}
	
	
	// 사용자 로그인창 폼 만들기
	@RequestMapping(value="/SigninUser")
	public String SigninUser() {
					// 로그인이 맞으면 인덱스 화면으로 넘기는걸 수정해야됨
		return "/user/signin/SigninUser";
	}
	//사용자 로그인화면 구현
	@ResponseBody
	@RequestMapping(value = "/SigninUser1")
	public Map<String, Object> SigninUser1(UserDto userDto, HttpSession httpSession) throws Exception {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();
			
		UserDto rtt = userService.selectId(userDto);
			
		if (rtt != null) {
			returnMap.put("rt", "success");
			httpSession.setAttribute("sessSeqXdm", rtt.getSuSeq());
			httpSession.setAttribute("sessIdXdm", rtt.getUserId());
			httpSession.setAttribute("sessNameXdm", rtt.getUserName());  

		} else {
			
			
		}
		    
		  
		    
			
		return returnMap;
	}
	
	//사용자 로그아웃 구현
	@ResponseBody
	@RequestMapping(value = "/SignoutUser1")
	public Map<String, Object> SignoutUser1(UserDto userDto,HttpSession httpSession) throws Exception {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();
			
		httpSession.setAttribute("sessSeqXdm", null);
		httpSession.setAttribute("sessIdXdm", null);
		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt", "success");
			
			
		return returnMap;
			
	}
	
	
	
	
	
	//관리자 로그인
	  @RequestMapping(value="/SigninAdimn") 
	  public String SigninAdimn () {
		  
		  
		  return "xdm/signinadmin/SigninAdimn"; 
	  }
	 
	
	//관리자 로그인 구현 
	@ResponseBody
	@RequestMapping(value = "/SigninAdimn1")
	public Map<String, Object> SigninAdimn(UserDto userDto,HttpSession httpSession) throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		UserDto rtt = userService.selectId(userDto);
		
		if (rtt != null) {
			returnMap.put("rt", "success");
			//httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqXdm", rtt.getSuSeq());
			httpSession.setAttribute("sessIdXdm", rtt.getUserId());
			httpSession.setAttribute("sessNameXdm", rtt.getUserName());

		} else {
			
			
		}
	    
		
	    
		
		return returnMap;
	}
	
	
	//관리자 로그아웃
	@ResponseBody
	@RequestMapping(value = "/SignoutAdimn1")
	public Map<String, Object> SignoutAdimn1(UserDto userDto,HttpSession httpSession) throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
			
			httpSession.setAttribute("sessSeqXdm", null);
			httpSession.setAttribute("sessIdXdm", null);
			httpSession.setAttribute("sessNameXdm", null);
			returnMap.put("rt", "success");
		
		return returnMap;
		
	}
	
	
}
