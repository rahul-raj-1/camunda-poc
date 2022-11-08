package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PlaceOrderService implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		
		OrderInfo order = (OrderInfo) execution.getVariable("orderInfo");
		
		System.out.println("Order Placed with order id  " + order.getOrderId() );

	}
}
