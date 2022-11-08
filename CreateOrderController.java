package com.example.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateOrderController  {
	
	  @Autowired 
	  private RuntimeService runtimeService; 
	  
	  @Autowired
	  private TaskService taskService;
	
	@PostMapping("/rest/create/order")
	public String createOrder(@RequestBody OrderInfo orderInfo) {
		System.out.println(" Order created with Order id  " + orderInfo.getOrderId());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("orderInfo", orderInfo);
 
        

        runtimeService.startProcessInstanceByKey("hello-world-process");// present  in process.bpmn.Hard coded value
        
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("hello-world-process");

        
        List<Task> taskList = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
        
        Task task = taskList.get(0);
        Map<String, Object> inputData = new HashMap<String, Object>();
        inputData.put("orderInfo", orderInfo);
        
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



        
        System.out.println("done");
        
        taskService.complete(task.getId(), inputData);



		return "execute started";
		
		
		
	}
	
	
	public void completeUserTask(String processInstanceId, String taskName, Map<String, Object> variables) {
	    // taskService is instance of org.camunda.bpm.engine.TaskService
	    String taskId = taskService.createTaskQuery()
	            .processInstanceId(processInstanceId)
	            .list()
	            .stream()
	            .filter(task -> task.getTaskDefinitionKey().equals(taskName))
	            .findFirst()
	            .orElseThrow(() -> new RuntimeException(
	                    String.format("Could not find task with name %s on processInstanceId %s",
	                            taskName,
	                            processInstanceId))).getId();
	    taskService.complete(taskId, variables);
	}


}
