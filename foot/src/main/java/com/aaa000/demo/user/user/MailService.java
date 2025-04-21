package com.aaa000.demo.user.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	
    @Autowired
    private JavaMailSender javaMailSender; 
    
    
	
	
//	회원가입 축하 메일
    public void sendMailWelcome(UserDto userDto) throws Exception{

    	
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
    	mimeMessageHelper.setFrom("rr1hhh1fff1@gmail.com");
    	mimeMessageHelper.setTo(userDto.getUserEmail()); 
    	mimeMessageHelper.setSubject("회원가입");
    	mimeMessageHelper.setText("회원가입 축하합니다", true); 
    	javaMailSender.send(mimeMessage);
    	
    }
	

	
}
