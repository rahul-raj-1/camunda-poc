package com.example.workflow;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderService implements JavaDelegate {
	
	@Autowired
	private RuntimeService  runtimeService;
	
	private ProcessEngine  processEngine;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		System.out.println("Create order id  " );
		

	}
}
