package com.example.spring.cloud.balancer;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;

/**
 * Author: 王俊超
 * Date: 2017-10-15 15:16
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class ConsistentHashBalancerClient extends RibbonLoadBalancerClient {
    public ConsistentHashBalancerClient() {
        this(null);
    }

    public ConsistentHashBalancerClient(SpringClientFactory clientFactory) {
        super(clientFactory);
    }
}
