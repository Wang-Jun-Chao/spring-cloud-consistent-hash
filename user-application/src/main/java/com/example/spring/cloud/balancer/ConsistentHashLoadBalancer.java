package com.example.spring.cloud.balancer;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;

/**
 * Author: 王俊超
 * Date: 2017-10-15 15:16
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class ConsistentHashLoadBalancer<T extends Server> extends ZoneAwareLoadBalancer<T> {

    public ConsistentHashLoadBalancer() {
    }

    public ConsistentHashLoadBalancer(IClientConfig clientConfig, IRule rule, IPing ping,
            ServerList<T> serverList, ServerListFilter<T> filter, ServerListUpdater serverListUpdater) {
        super(clientConfig, rule, ping, serverList, filter, serverListUpdater);
    }

    public ConsistentHashLoadBalancer(IClientConfig niwsClientConfig) {
        super(niwsClientConfig);
    }

    @Override
    public String choose(Object key) {
        return super.choose(key);
    }

    @Override
    public Server chooseServer() {
        return super.chooseServer();
    }

    @Override
    public Server chooseServer(Object key) {
        return super.chooseServer(key);
    }


}
