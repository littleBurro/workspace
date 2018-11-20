package com.example.ribbonconsumer.config;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MyRibbonConfiguration {

    @Bean
    public IPing ribbonPing(IClientConfig config){
        return new PingUrl();
    }

    @Bean
    public IClientConfig clientConfig(){
        return new DefaultClientConfigImpl();
    }
}
