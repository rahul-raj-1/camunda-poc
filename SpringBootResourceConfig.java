package com.example.workflow;

import javax.ws.rs.ApplicationPath;

import org.camunda.bpm.spring.boot.starter.rest.CamundaJerseyResourceConfig;
import org.springframework.stereotype.Component;

//@Component
//@ApplicationPath("/custom")
public class SpringBootResourceConfig extends CamundaJerseyResourceConfig {
    @Override
    protected void registerAdditionalResources() {
        this.register(CreateOrderController.class);
    }
}
