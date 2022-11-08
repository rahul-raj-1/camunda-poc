/*
 * package com.example.workflow;
 * 
 * import java.util.Collections; import java.util.UUID;
 * 
 * import org.camunda.bpm.engine.RuntimeService; import
 * org.springframework.beans.factory.InitializingBean; import
 * org.springframework.stereotype.Component;
 * 
 * @Component public class StartWorkflow implements InitializingBean {
 * 
 * private final RuntimeService runtimeService;
 * 
 * public StartWorkflow(RuntimeService runtimeService) { this.runtimeService =
 * runtimeService; }
 * 
 * 
 * 
 * @Override public void afterPropertiesSet() throws Exception {
 * runtimeService.startProcessInstanceByKey("StartEvent_1",
 * Collections.singletonMap("messageId", UUID.randomUUID().toString()));
 * 
 * 
 * }
 * 
 * 
 * 
 * }
 */