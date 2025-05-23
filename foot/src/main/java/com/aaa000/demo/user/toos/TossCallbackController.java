package com.aaa000.demo.user.toos;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TossCallbackController {
	
	
    @GetMapping("/success")
    public String success(@RequestParam Map<String, String> allParams, Model model) {
        // 여기에 결제 승인 정보 확인 로직 추가 가능
        model.addAttribute("result", allParams);
        return "user/pay/success"; // 결제 성공 페이지
    }

    @GetMapping("/fail")
    public String fail(@RequestParam Map<String, String> allParams, Model model) {
        model.addAttribute("error", allParams);
        return "user/pay/fail"; // 결제 실패 페이지
    }

}
