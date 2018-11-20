package com.example.ribbonconsumer.controller;

import com.example.ribbonconsumer.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Autowired
    DemoService demoService;

    @GetMapping("/ribbon-consumer")
    public String testConsumer() {
        return demoService.domeService(new Random().nextLong());


//        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://DOME-SERVICE/test/eureka/test", String.class);
//        //第一种
//        responseEntity = restTemplate.getForEntity("http://DOME-SERVICE/test/eureka/test?userName={1}", String.class, "user");
//        //第二种
//        Map<String, Object> map = new HashMap<>();
//        map.put("userName", "user");
//        responseEntity = restTemplate.getForEntity("http://DOME-SERVICE/test/eureka/test?userName={userName}", String.class, map);
//        //第三种
//        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://DOME-SERVICE/test/eureka/test?userName={userName}")
//                .build()
//                .expand("user")
//                .encode();
//        URI uri = uriComponents.toUri();
//        responseEntity = restTemplate.getForEntity(uri, String.class);
//        return responseEntity.getBody();

//        return restTemplate.getForObject("http://DOME-SERVICE/test/eureka/test", String.class);
    }

    @GetMapping(value = "/testHystrix")
    public String testHystrix() {
        return null;
    }
}
