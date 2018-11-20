package com.example.ribbonconsumer.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

public class UserPostCommand extends HystrixCommand<String> {
    private RestTemplate restTemplate;
    private Long id;

    public UserPostCommand(RestTemplate restTemplate, Long id){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetSetGet")));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected String run() throws Exception {
        String str = restTemplate.getForObject("http://DOME-SERVICE/user/getUser", String.class);
        UserGetCommand.flushCache(id);
        return str;
    }
}
