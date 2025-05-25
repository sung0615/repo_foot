package com.aaa000.demo.user.pay;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa000.demo.user.futsalinformation.FutsalinformationDto;
import com.aaa000.demo.user.reservationprocess.ReservationprocessDto;
import com.aaa000.demo.user.reservationprocess.ReservationprocessService;

import jakarta.servlet.http.HttpSession;

@Controller
public class WidgetController {
	
	@Autowired
	ReservationprocessService reservationprocessService;
	
	@Autowired
	PayService payService;
	
	@Value("${TOSS_SECRET_KEY}")
	private String tossSecretKey;
	
	
	@RequestMapping("/fail")
	public String fail() {
	    return "user/pay/fail";
	}

	@RequestMapping("/success")
	public String success(@ModelAttribute("item") PaymentResultDto dto,HttpSession session, Model model,FutsalinformationDto futsalinformationDto) {
		System.out.println(dto.getMatchingTeamIntroduction());
	    return "user/pay/success"; 
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/confirm/payment")
	public ResponseEntity<String> payment(@RequestBody Map<String, Object> payload,
			HttpSession httpSession) throws IOException, InterruptedException {
		
	
		PaymentResultDto dto = new PaymentResultDto();
		dto.setPaymentKey((String) payload.get("paymentKey"));
		dto.setOrderId((String) payload.get("orderId"));
	    dto.setAmount(Integer.valueOf(payload.get("amount").toString()));
	    
	    dto.setReservationDate((String) payload.get("reservationDate"));
	    dto.setReservationTime((String) payload.get("reservationTime"));
	    dto.setMatchingOnOff((String) payload.get("matchingOnOff"));
	    dto.setMatchingDeposit((Integer) payload.get("matchingDeposit"));
	    dto.setMatchingBankName((String) payload.get("matchingBankName"));
	    dto.setMatchingBankNumbar((String) payload.get("matchingBankNumbar"));
	    dto.setMatchingVs((String) payload.get("matchingVs"));
	    dto.setMatchingTeamLevel((String) payload.get("matchingTeamLevel"));
	    dto.setMatchingTeamName((String) payload.get("matchingTeamName"));
	    dto.setMatchingTeamIntroduction((String) payload.get("matchingTeamIntroduction"));
	    dto.setSuSeq((String) payload.get("suSeq"));
	    dto.setFiSeq((String) payload.get("fiSeq"));
	    dto.setRegDateTime((String) payload.get("regDateTime"));
	    dto.setRpDelMy((Integer) payload.get("rpDelMy"));
	    
	    System.out.println(dto.getMatchingTeamIntroduction());
	    
	   
	    String json = String.format("{\"paymentKey\":\"%s\",\"amount\":%d,\"orderId\":\"%s\"}",
                dto.getPaymentKey(), dto.getAmount(), dto.getOrderId());
	    String authValue = Base64.getEncoder().encodeToString((tossSecretKey + ":").getBytes());
	   
	    HttpRequest request = HttpRequest.newBuilder()
    	    .uri(URI.create("https://api.tosspayments.com/v1/payments/confirm"))
    	    .header("Authorization", "Basic " + authValue)
    	    .header("Content-Type", "application/json")
    	    .method("POST", HttpRequest.BodyPublishers.ofString(json))
    	    .build();
    	HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    	String responseBody = response.body();
    	System.out.println(responseBody);
    	
    	
//    	System.out.println(extractValueFromJson(responseBody,"orderName"));
    	

    	
    	payService.save(dto); // DB 저저장

     
    	
    	
    	
    	return ResponseEntity.status(response.statusCode()).body(response.body());
	}
	
	private static String extractValueFromJson(String json, String key) {
        int keyIndex = json.indexOf(key);
        if (keyIndex == -1) {
            return null; // 키가 없으면 null 반환
        }
        int startIndex = json.indexOf(":", keyIndex) + 1;
        int endIndex = json.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = json.indexOf("}", startIndex);
        }
        return json.substring(startIndex, endIndex).replace("\"", "").trim(); // 따옴표 제거하고 반환
    }
	
	
	@RequestMapping("/finalSuccess")
	public String finalSuccess(@RequestParam Map<String, String> paramMap, Model model) {
	    // paramMap에 모든 값이 들어 있음
		
	    model.addAttribute("data", paramMap);
	    return "user/pay/finalSuccess"; // 결제 성공 페이지
	}
	
	

	
} 
