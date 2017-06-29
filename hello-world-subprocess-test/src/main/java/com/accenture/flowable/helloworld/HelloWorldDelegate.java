package com.accenture.flowable.helloworld;

import org.flowable.engine.delegate.BpmnError;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldDelegate implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) {
		String message = (String) execution.getVariable("message");
		System.out.println("Message to invoke: " + message);
		
		String tu = (String) execution.getVariable("tu");
		System.out.println("Ending hello world with transaction unit: " + tu);
		
		throw new BpmnError("helloWorldErrorOccured");
	}

}
