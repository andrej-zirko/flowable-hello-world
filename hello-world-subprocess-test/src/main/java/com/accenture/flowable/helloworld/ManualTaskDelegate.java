package com.accenture.flowable.helloworld;

import java.util.Random;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class ManualTaskDelegate implements JavaDelegate {
	Random randomGenerator = new Random();
	
	@Override
	public void execute(DelegateExecution execution) {
		Object retry = execution.getVariable("retry");		
		System.out.println("Manual intervention retry result: " + retry);		
	}
	
}
