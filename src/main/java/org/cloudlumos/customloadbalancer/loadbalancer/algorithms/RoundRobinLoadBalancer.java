package org.cloudlumos.customloadbalancer.loadbalancer.algorithms;

import org.cloudlumos.customloadbalancer.loadbalancer.LoadBalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalancer implements LoadBalancer {
    private final List<String> nodes = new ArrayList<>();
    private final AtomicInteger currentIndex = new AtomicInteger(0);

    @Override
    public void addNode(String node) {
        nodes.add(node);
    }

    @Override
    public void removeNode(String node) {
        nodes.remove(node);
    }

    @Override
    public String getNode(String key) {
        if (nodes.isEmpty()) {
            return null;
        }
        int index = currentIndex.getAndIncrement() % nodes.size();
        return nodes.get(index);
    }
}
