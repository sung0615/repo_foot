package com.aaa000.demo.user.user;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aaa000.demo.common.util.UtilDateTiem;
import com.aaa000.demo.module.code.CodeVo;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController<userService> {
	
	
	@Autowired
	UserService userService;
	@Autowired
	MailService mailService;

	
	

	
	// 사용자 회원 가입 리스트 관리자에서 보여주기
	@RequestMapping(value="/MemberXdmList")
	public String MemberXdmList(Model model, UserVo vo,UserDto userDto) {
		
		model.addAttribute("item", userService.selectOne(userDto));
		vo.setParamsPaging(userService.selectOneCount(vo));
		model.addAttribute("list", userService.selectList(vo));
		model.addAttribute("vo", vo);
		
		
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTiem.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTiem.add59TimeString(vo.getShDateEnd()));
		
		return "xdm/usermember/MemberXdmList";
	}
	
	
	
	
	
	// 사용자 회원가입하기 등록폼 하기 (회원가입 후 로그인 주소로 가겠끔 수정해야함)
	@RequestMapping(value="/SignupUserForm")
	public String SignupUserForm(Model model,UserDto userDto, CodeVo vo) {
		
	   
		
		model.addAttribute("list", userService.codeList(userDto));
		model.addAttribute("item", userService.selectOne(userDto));
		
		
		return "user/signup/SignupUserForm";
	}
	@RequestMapping(value="/SignupUserInst")
	public String SignupUserInst(UserDto userDto,UserVo vo) {
		
		// 암호화
		userDto.setUserPassword(encodeBcrypt(userDto.getUserPassword(), 10));
		 
		userService.insert(userDto);
		// thread 사용해서 메일 전송 빠르게
		Thread thread = new Thread(new Runnable() {
		    @Override
		    public void run() {
		        try {
		            // 여기에 실행할 코드 작성
		            mailService.sendMailWelcome(userDto);  //회원가입 축하 메일 전송
		        } catch (Exception e) {
		            e.printStackTrace(); // 예외 처리
		        }
		    }
		});
		thread.start(); //실행
							
		return "redirect:/SigninUser";
	}
	
	@ResponseBody
	@RequestMapping(value = "/SignupUserForm1")
	public Map<String, Object> SignupUserForm1(UserDto userDto) throws Exception {
	    Map<String, Object> returnMap = new HashMap<>();
	   
	    int count = userService.idDuplicate(userDto); // count 값 리턴하도록 수정 필요
	    System.out.println(count);
	    returnMap.put("count", count);

	    return returnMap;
	}
	

	
	
	// 회원 정보 관리자 Ui 상세 뿌리기
	@RequestMapping(value="/MemberXdmView")
	public String MemberXdmView(Model model,UserDto userDto) {
		
		model.addAttribute("item", userService.selectOne(userDto));
		return "xdm/usermember/MemberXdmView";
	}
	
	
	
	
	// 유저 가입 가입 헀던거 수정하기 my페이지 안에 보여주고 수정하기
	@RequestMapping(value = "/AccountSettingsUserMfom")
	public String AccountSettingsUserMfom(Model model,UserDto userDto, UserVo vo , HttpSession httpSession) {
		
		userDto.setSuSeq((String) httpSession.getAttribute("sessSeqUser"));
		
		model.addAttribute("list", userService.selectList(vo));
		model.addAttribute("item", userService.selectOne(userDto)); //기존 데이터 불러 오기
		
		
		return "user/accountsettings/AccountSettingsUserMfom";
	}
	//수정한 데이터를 수정하고 my페이지 정보수정페이지  찾아라
	@RequestMapping(value="/AccountSettingsUserUpdt")
	public String AccountSettingsUserUpdt(UserDto userDto,HttpSession httpSession) {
		httpSession.getAttribute("sessSeqUser");
		userDto.setSuSeq((String) httpSession.getAttribute("sessSeqUser"));
		
		userService.update(userDto);
		
		return "redirect:/AccountSettingsUserMfom";
	}
	
	
	
	// 유저 가입 가입 헀던거 비밀번호 수정하기 my페이지 안에 보여주고 수정하기
	@RequestMapping(value="/PasswordChangeUserMfom")
	public String PasswordChangeUserMfom(Model model,UserDto userDto, HttpSession httpSession) {
		httpSession.getAttribute("sessSeqUser");
		

		userDto.setSuSeq((String) httpSession.getAttribute("sessSeqUser"));
		
		model.addAttribute("list", userService.selectOne(userDto));
	
		model.addAttribute("item", userService.selectOne(userDto)); //기존데이터 불러오기
		return "user/passwordchange/PasswordChangeUserMfom";
	}
	// 수정한 데이터 수정하고 my페이지 비밀번호 수정페이지를 찾아라
	@RequestMapping(value="/PasswordChangeUserUpdt")
	public String PasswordChangeUserUpdt(UserDto userDto,HttpSession httpSession) {
		httpSession.getAttribute("sessSeqUser");
		userDto.setSuSeq((String) httpSession.getAttribute("sessSeqUser"));
		
		// 암호화
		userDto.setUserPassword(encodeBcrypt(userDto.getUserPassword(), 10));
		
		userService.updatePassword(userDto); //페스워드 수정
		return "redirect:/PasswordChangeUserMfom";
	}
	
	
	
	// 사용자 업데이트 삭제
	@RequestMapping(value="/SecessionUserUele")
	public String SecessionUserUele(UserDto userDto,HttpSession httpSession) {
		httpSession.getAttribute("sessSeqUser");
		userDto.setSuSeq((String) httpSession.getAttribute("sessSeqUser"));
		
		
		return "user/secession/SecessionUserUele"; 
	}
	// 사용자 업데이트 
		@RequestMapping(value="/SecessionUele")
		public String SecessionUele(UserDto userDto,HttpSession httpSession) {
			httpSession.getAttribute("sessSeqUser");
			userDto.setSuSeq((String) httpSession.getAttribute("sessSeqUser"));
			
			userService.uelete(userDto); //업데이트 삭제 데이터 가져오기
			return "user/secession/SecessionUserUele"; 
		}
	
	
	// 사용자 로그인창 폼 만들기
	@RequestMapping(value="/SigninUser")
	public String SigninUser() {
					// 로그인이 맞으면 인덱스 화면으로 넘기는걸 수정해야됨
		return "user/signin/SigninUser";
	}
	//사용자 로그인화면 구현
	@ResponseBody
	@RequestMapping(value = "/SigninUser1")
	public Map<String, Object> SigninUser1(UserDto userDto, HttpSession httpSession) throws Exception {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();
			
		UserDto rtt = userService.selectId(userDto);
	
			
			if (matchesBcrypt(userDto.getUserPassword(), rtt.getUserPassword(), 10)) {
				
				returnMap.put("rt", "success");
				httpSession.setAttribute("sessSeqUser", rtt.getSuSeq()); //사용자Seq
				httpSession.setAttribute("sessIdUser", rtt.getUserId()); // ID
				httpSession.setAttribute("sessNameUser", rtt.getUserName());   //이름
				httpSession.setAttribute("sessBirthdayUser", rtt.getUserBirthday()); //생일
				httpSession.setAttribute("sessUserPassword", rtt.getUserPassword()); //비밀번호
				
				
				httpSession.setAttribute("sessGenderUser", rtt.getGenderName()); //성별 남자 여자
				httpSession.setAttribute("sessUserGender", rtt.getUserGender()); //성별  5  6
				
				
	
			} else {
				
				
			}
			return returnMap;
			
		
		
		
	}
//	// 카카오톡 로그인 구현 
//	@GetMapping("/auth/kakao/callback")
//	public String kakaoLogin(@RequestParam("code") String code, HttpSession session) throws Exception {
//
//	    // 1. code로 access token 요청
//	    String accessToken = kakaoService.getAccessToken(code);
//
//	    // 2. access token으로 사용자 정보 요청
//	    UserDto kakaoUser = kakaoService.getUserInfo(accessToken);
//
//	    // 3. 회원가입 or 기존 회원 로그인 처리
//	    UserDto loginUser = userService.findOrCreateKakaoUser(kakaoUser);
//
//	    // 4. 세션 저장
//	    session.setAttribute("sessSeqUser", loginUser.getSuSeq()); //사용자Seq
//	    session.setAttribute("sessIdUser", loginUser.getUserId()); // ID
//	    session.setAttribute("sessNameUser", loginUser.getUserName());   //이름
//	    session.setAttribute("sessBirthdayUser", loginUser.getUserBirthday()); //생일
//	    session.setAttribute("sessUserPassword", loginUser.getUserPassword()); //비밀번호
//		
//		
//	    session.setAttribute("sessGenderUser", loginUser.getGenderName()); //성별 남자 여자
//	    session.setAttribute("sessUserGender", loginUser.getUserGender()); //성별  5  6
//
//	    return "redirect:/SigninUser"; // 로그인 후 홈으로
//	}

	
	//사용자 로그아웃 구현
	@ResponseBody
	@RequestMapping(value = "/SignoutUser1")
	public Map<String, Object> SignoutUser1(UserDto userDto,HttpSession httpSession) throws Exception {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();
			
		httpSession.setAttribute("sessSeqUser", null);
		httpSession.setAttribute("sessIdUser", null);
		httpSession.setAttribute("sessNameUser", null);
		/* httpSession.invalidate(); */ //세션 전체 초기화
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
		
		if (matchesBcrypt(userDto.getUserPassword(), rtt.getUserPassword(), 10)) {
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
	
	
	
	// 비밀번호 암포화
	// 회원가입시 암포화
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

	// 로그인 했을때 암호화 비교 후 로그인		
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}
	
	
	
	
	@RequestMapping(value = "/blogXdmExcel")
	public void exportBlogsToCsv(HttpServletResponse response, UserVo vo) throws Exception {
	    // 페이징 무시: rowNumToShow를 Integer.MAX_VALUE로 설정하거나,
	    
	    vo.setParamsPaging(userService.selectOneCount(vo));
	    List<UserDto> blogs = userService.selectList(vo);

	    response.setContentType("text/xls; charset=UTF-8");
	    response.setHeader("Content-Disposition", "attachment; filename=\"user.xls\"");

	    OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8);
	    writer.write('\uFEFF'); // BOM

	    // 헤더
	    writer.write("이름,성별,통신사,폰번호,생일,ID,이메일,등록일,수정일\n");

	    // 내용
	    for (UserDto blog : blogs) {
	        String phone = "=" + "\"" + blog.getUserPhoneNumber() + "\""; // 문자로 강제 처리
	        String birthday = "=" + "\"" + blog.getUserBirthday() + "\"";
	        String regDate = "=" + "\"" + blog.getRegDateTime() + "\"";
	        String modDate = "=" + "\"" + blog.getModDateTime() + "\"";

	        writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
	            blog.getUserName(),
	            blog.getUserGender(),
	            blog.getUserNewsAgency(),
	            phone,
	            birthday,
	            blog.getUserId(),
	            blog.getUserEmail(),
	            regDate,
	            modDate
	        ));
	    }

	    writer.flush();
	    writer.close();
	}
	

	
	
	
	
	
	
	
	
	
}
