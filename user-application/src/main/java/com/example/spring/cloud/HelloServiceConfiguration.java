package com.example.spring.cloud;

import com.example.spring.cloud.balancer.ConsistentHashBalancerClient;
import com.example.spring.cloud.balancer.ConsistentHashLoadBalancer;
import com.example.spring.cloud.balancer.ConsistentHashRule;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequestFactory;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Author: 王俊超
 * Date: 2017-10-15 12:17
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class HelloServiceConfiguration {

    @Autowired
    IClientConfig config;

    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new PingUrl();
    }

    @Bean
    @Primary
    public IRule consistentHashRule(IClientConfig config) {
        return new ConsistentHashRule();
    }

    @Bean
    @Primary
    public ILoadBalancer consistentHashLoadBalancer(IClientConfig config, IRule rule) {
        ConsistentHashLoadBalancer balancer = new ConsistentHashLoadBalancer(config);
        balancer.setRule(rule);

        return balancer;
    }

    @Bean
    @Primary
    public LoadBalancerClient consistentHashBalancerClient(SpringClientFactory factory) {
        return new ConsistentHashBalancerClient(factory);
    }

    @Bean
    @Primary
    public LoadBalancerRequestFactory loadBalancerRequestFactory(LoadBalancerClient client) {
        return new LoadBalancerRequestFactory(client);
    }
}