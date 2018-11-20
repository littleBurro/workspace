package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;


@RestController
@RequestMapping(value = "/test/eureka")
public class EurekaController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Qualifier("eurekaRegistration")
    @Autowired
    private Registration registration;

    @Autowired
    private DiscoveryClient client;

    @GetMapping(value = "/test")
    public String test() throws Exception{
        List<ServiceInstance> instanceList = client.getInstances(registration.getServiceId());
        instanceList.forEach(serviceInstance -> logger.info("host: " + serviceInstance.getHost() + ", service_id: " + serviceInstance.getServiceId()));

        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime: " + sleepTime);
        Thread.sleep(1000);
        return "eureka test";
    }
}
