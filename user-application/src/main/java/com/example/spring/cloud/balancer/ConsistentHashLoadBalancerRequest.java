package com.example.spring.cloud.balancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;

/**
 * Author: 王俊超
 * Date: 2017-10-15 18:34
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public  abstract  class ConsistentHashLoadBalancerRequest implements LoadBalancerRequest<ClientHttpResponse> {
    HttpRequest request;

    public ConsistentHashLoadBalancerRequest() {
    }

    public ConsistentHashLoadBalancerRequest(HttpRequest request) {
        this.request = request;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

}
