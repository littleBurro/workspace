package com.example.ribbonconsumer.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

public class UserCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;
    private Long id;

    public UserCommand(RestTemplate restTemplate, Long id){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("DomeGroup")));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected String run() throws Exception {
        return restTemplate.getForObject("http://DOME-SERVICE/user/getUser", String.class);
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }
}
