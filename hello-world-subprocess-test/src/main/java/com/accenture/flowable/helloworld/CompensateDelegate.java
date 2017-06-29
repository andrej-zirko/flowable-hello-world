package com.accenture.flowable.helloworld;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class CompensateDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		String tu = (String) execution.getVariable("tu");
		System.out.println("Compensation delegate with transaction unit -  " + tu + " - via a REST call");
	}

}
