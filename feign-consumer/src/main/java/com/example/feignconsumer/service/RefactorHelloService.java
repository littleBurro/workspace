package com.example.feignconsumer.service;

import com.example.helloserviceapi.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient(value = "dome-service")
public interface RefactorHelloService extends HelloService {
}
