package com.example.spring.cloud.balancer;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.Server;

/**
 * Author: 王俊超
 * Date: 2017-10-15 15:15
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class ConsistentHashRule extends AvailabilityFilteringRule {

    @Override
    public Server choose(Object key) {
        return super.choose(key);
    }


}
