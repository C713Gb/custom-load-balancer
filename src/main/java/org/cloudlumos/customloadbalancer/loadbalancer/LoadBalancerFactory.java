package org.cloudlumos.customloadbalancer.loadbalancer;

import org.cloudlumos.customloadbalancer.loadbalancer.algorithms.ConsistentHashRing;
import org.cloudlumos.customloadbalancer.loadbalancer.algorithms.HashFunction;
import org.cloudlumos.customloadbalancer.loadbalancer.algorithms.RoundRobinLoadBalancer;

public class LoadBalancerFactory {
    public enum Algorithm {
        CONSISTENT_HASH, ROUND_ROBIN
    }

    public static LoadBalancer createLoadBalancer(Algorithm algorithm) {
        return switch (algorithm) {
            case CONSISTENT_HASH -> new ConsistentHashRing(new HashFunction(), 100);
            case ROUND_ROBIN -> new RoundRobinLoadBalancer();
            default -> throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        };
    }
}
