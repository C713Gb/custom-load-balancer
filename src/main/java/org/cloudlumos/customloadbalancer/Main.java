package org.cloudlumos.customloadbalancer;

import org.cloudlumos.customloadbalancer.loadbalancer.LoadBalancer;
import org.cloudlumos.customloadbalancer.loadbalancer.LoadBalancerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Bean
    public LoadBalancer loadBalancer() {
        // Choose the algorithm here
        return LoadBalancerFactory.createLoadBalancer(LoadBalancerFactory.Algorithm.CONSISTENT_HASH);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
