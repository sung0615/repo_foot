package com.aaa000.demo.user.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayService {
	
	@Autowired
	PayDao payDao;
	
	
	//인설트
	public int save(PaymentResultDto entity) {
		
		return payDao.save(entity);
	}
	


	
}
