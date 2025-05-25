package com.aaa000.demo.user.pay;

import org.springframework.stereotype.Repository;

@Repository
public interface PayDao {
	
	// 결제 인설트
	public int save(PaymentResultDto entity);

	
}
