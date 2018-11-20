package com.example.ribbonconsumer.service;

import com.example.ribbonconsumer.hystrix.UserCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class DemoService {
    Logger logger = LoggerFactory.getLogger(DemoService.class);

    @Autowired
    RestTemplate restTemplate;


    /**
     * hystrix 请求缓存
     * @param id
     * @return
     */
    @CacheResult(cacheKeyMethod = "getDomeCacheKey")
    @HystrixCommand(fallbackMethod = "domeFallBack", ignoreExceptions = Exception.class,
                threadPoolProperties = {
                @HystrixProperty(name = "coreSize", value = "20"),
                @HystrixProperty(name = "maxQueueSize", value = "-1")})
    public String domeService(@CacheKey("id") Long id){
        long startTime = System.currentTimeMillis();
//        throw new RuntimeException("this is dome exception");
        String result = restTemplate.getForObject("http://DOME-SERVICE/test/eureka/test", String.class);
        long endTime = System.currentTimeMillis();
        logger.info("Spend time: " + (endTime - startTime));
        return result;
    }

    /**
     * hystrix请求降级
     * @param throwable
     * @return
     */
    @HystrixCommand(commandKey = "domeHystrix", groupKey = "domeGroup", threadPoolKey = "domeHystrixThread")
    public String domeFallBack(Throwable throwable){
        logger.info(throwable.getMessage());
        return "error hystrix";
    }

    /**
     * hystrix缓存key生成方法
     * @param id
     * @return
     */
    private String getDomeCacheKey(Long id){
        return String.valueOf(id);
    }

    /**
     * 清除hystrix请求缓存
     * @param id
     */
    @CacheRemove(commandKey = "domeService")
    @HystrixCommand
    public void update(@CacheKey("id") Long id){
        logger.info("更新操作");
    }

    public String domeFallSec(){
        return "second error";
    }

    public String testHystrix(){
//        String str1 = new UserCommand(new com.netflix.hystrix.HystrixCommand.Setter(), restTemplate, 1L).execute();
//        new UserCommand(restTemplate, 1L).queue();
        return null;
    }
}
