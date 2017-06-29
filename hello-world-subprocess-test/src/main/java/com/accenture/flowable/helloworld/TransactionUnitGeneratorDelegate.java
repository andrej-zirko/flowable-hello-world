package com.accenture.flowable.helloworld;

import java.util.UUID;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class TransactionUnitGeneratorDelegate implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) {
		String tuUUID = UUID.randomUUID().toString();
		
		Object tu = execution.getVariable("tu");
		
		if (tu == null) {
			execution.setVariable("tu", tuUUID);			
		}
	}

}
