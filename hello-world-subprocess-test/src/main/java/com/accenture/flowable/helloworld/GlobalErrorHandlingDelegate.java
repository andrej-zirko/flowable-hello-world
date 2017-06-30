package com.accenture.flowable.helloworld;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GlobalErrorHandlingDelegate implements JavaDelegate {
	private static final Logger logger = LoggerFactory.getLogger(GlobalErrorHandlingDelegate.class);
	
	@Override
	public void execute(DelegateExecution execution) {
		logger.info("Global error handling. Here a list of transactions will be rolled back");
	}

}
