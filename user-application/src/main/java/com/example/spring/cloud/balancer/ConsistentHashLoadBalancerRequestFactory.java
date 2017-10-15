package com.example.spring.cloud.balancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

import java.util.List;

/**
 * Author: 王俊超
 * Date: 2017-10-15 18:31
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class ConsistentHashLoadBalancerRequestFactory extends LoadBalancerRequestFactory {

    private LoadBalancerClient loadBalancer;
    private List<LoadBalancerRequestTransformer> transformers;

    public ConsistentHashLoadBalancerRequestFactory(LoadBalancerClient loadBalancer,
            List<LoadBalancerRequestTransformer> transformers) {
        super(loadBalancer, transformers);
        this.loadBalancer = loadBalancer;
        this.transformers = transformers;
    }

    public ConsistentHashLoadBalancerRequestFactory(LoadBalancerClient loadBalancer) {
        super(loadBalancer);
        this.loadBalancer = loadBalancer;
    }


    @Override
    public LoadBalancerRequest<ClientHttpResponse> createRequest(final HttpRequest request,
            final byte[] body, final ClientHttpRequestExecution execution) {
        return new ConsistentHashLoadBalancerRequest(request) {

            @Override
            public ClientHttpResponse apply(final ServiceInstance instance)
                    throws Exception {
                HttpRequest serviceRequest = new ServiceRequestWrapper(request, instance, loadBalancer);
                if (transformers != null) {
                    for (LoadBalancerRequestTransformer transformer : transformers) {
                        serviceRequest = transformer.transformRequest(serviceRequest, instance);
                    }
                }
                return execution.execute(serviceRequest, body);
            }

        };
    }
}
