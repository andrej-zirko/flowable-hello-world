package com.accenture.flowable.helloworld;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class GlobalErrorHandlingDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("Global error handling. Here a list of transactions will be rolled back");
	}

}
