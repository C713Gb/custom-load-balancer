package org.cloudlumos.customloadbalancer.loadbalancer;

public interface LoadBalancer {
    void addNode(String node);
    void removeNode(String node);
    String getNode(String key);
}
