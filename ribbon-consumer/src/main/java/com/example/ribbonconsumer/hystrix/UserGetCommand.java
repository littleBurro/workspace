package com.example.ribbonconsumer.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;

public class UserGetCommand extends HystrixCommand<String> {
    private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("CommandKey");

    private RestTemplate restTemplate;
    private Long id;

    public UserGetCommand(RestTemplate restTemplate, Long id){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetSetGet")).andCommandKey(GETTER_KEY));
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

    public static void flushCache(Long id){
        HystrixRequestCache.getInstance(GETTER_KEY, HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(id));
    }
}
