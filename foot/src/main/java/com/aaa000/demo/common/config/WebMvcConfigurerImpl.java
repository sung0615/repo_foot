package com.aaa000.demo.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.aaa000.demo.common.interceptor.CheckLoginSessionInterceptor;
//자동으로 함수를 시랭시ㅕ라
@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CheckLoginSessionInterceptor())
//		.order(1)
		.addPathPatterns("/*User*" , "/*Xdm*" , "/*/*Xdm*")
		.excludePathPatterns(
//				"/resources/**",
				// 사용자 로그인 안했을때 보여줄수 있는 주소
				"/*user*",
				"/indexUserView", //인덱스 화면
				"/ReservationUserList", //예약가능 화면
				"/AnnouncementUserList", //공지사항
				"/SocialMatchUserList", //소셜매칭 리스트
				"/DetailedPageUserForm", //풋살장 예약 상세페이지
				"/SigninUser", // 로그인 폼
				"/SignupUserForm", //회원 가입폼
				"/SigninUser1", //로그인 동작 
			
				
				// 관리자 로그인하기전에 로그인 폼만 보여주고 나머지 XX
				"/*Xdm*/",
			
				"/SigninAdimn", // 관리자 로그인화면
				"/SigninAdimn1" // 관리 로그인 동작
				
		);
	
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	

}
