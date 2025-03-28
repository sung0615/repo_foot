package com.aaa000.demo.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckLoginSessionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		
//		사용자용
		System.out.println("fkdfdsjofjdsjfodsofjd");
		if(request.getRequestURI().contains("User")) { 
			System.out.println(request.getRequestURI().contains("User"));
			if (request.getSession().getAttribute("sessSeqUser") != null) {
				// by pas
				
			} else {
				response.sendRedirect("SigninUser");
				return false;
			}
		} else {
//			by pass
		}
		
//		관리자용
		if(request.getRequestURI().contains("Xdm")) {
			System.out.println("1");
			if (request.getSession().getAttribute("sessSeqXdm") != null) {
				System.out.println("2");
				// by pass
			} else {
				System.out.println("3");
				response.sendRedirect("/SigninAdimn");
		        return false;
			}
		} else {
//			by pass
		}
	
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
