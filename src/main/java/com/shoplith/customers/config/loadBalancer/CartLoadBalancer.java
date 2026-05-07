package com.shoplith.customers.config.loadBalancer;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(value = "cart-service")
public class CartLoadBalancer {

    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder(){
        return new Feign.Builder();
    }

}
