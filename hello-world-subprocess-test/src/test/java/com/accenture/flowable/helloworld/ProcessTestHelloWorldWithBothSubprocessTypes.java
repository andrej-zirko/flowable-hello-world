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
public class ProcessTestHelloWorldWithBothSubprocessTypes {
	private static final String STANDALONE_SUBPROCESS_FLAG_VARIABLE_NAME = "standalone";
	private static final String LOCAL_ERROR_WITHOUT_CATCH_FLAG_VARIABLE_NAME = "localErrorWithoutCatch";
	private static final String LOCAL_ERROR_FLAG_VARIABLE_NAME = "localError";
	private static final String PROCESS_KEY_UNDER_TEST = "helloWorldWithBothSubProcessTypes";
	@Autowired
	private RuntimeService runtimeService;
	
	@Test
	public void bothLocalAndGlobalErrorHandlingHandlesError_given_embeddedSubprocess_when_throwingLocalErrorWithLocalCatch() throws Exception {
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put(LOCAL_ERROR_FLAG_VARIABLE_NAME, true);
		variableMap.put(STANDALONE_SUBPROCESS_FLAG_VARIABLE_NAME, false);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_KEY_UNDER_TEST, variableMap);
		
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
	}

	@Test
	public void globalErrorHandlingHandlesError_given_standaloneSubprocess_when_throwingLocalErrorWithoutLocalCatch() throws Exception {
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put(LOCAL_ERROR_FLAG_VARIABLE_NAME, false);
		variableMap.put(LOCAL_ERROR_WITHOUT_CATCH_FLAG_VARIABLE_NAME, true);
		variableMap.put(STANDALONE_SUBPROCESS_FLAG_VARIABLE_NAME, true);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_KEY_UNDER_TEST, variableMap);
		
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
	}
	
	@Test
	public void bothLocalAndGlobalErrorHandlingHandlesError_given_standaloneSubprocess_when_throwingLocalError() throws Exception {
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put(LOCAL_ERROR_FLAG_VARIABLE_NAME, true);
		variableMap.put(STANDALONE_SUBPROCESS_FLAG_VARIABLE_NAME, true);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_KEY_UNDER_TEST, variableMap);
		
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
	}

}