package com.accenture.flowable.helloworld;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessTestHelloWorldProcess {
	@Autowired
	private RuntimeService runtimeService;
	
	@Test
	public void bothLocalAndGlobalErrorHandlingHandlesError_given_throwingTask() throws Exception {
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("message", "Test message");
		variableMap.put("retry", true);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("helloWorldProcess", variableMap);
		
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
	}
}