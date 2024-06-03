package org.cloudlumos.customloadbalancer.loadbalancer.algorithms;

import org.cloudlumos.customloadbalancer.loadbalancer.LoadBalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashRing implements LoadBalancer {
    private final HashFunction hashFunction;
    private final int replicas;
    private final SortedMap<Integer, String> circle = new TreeMap<>();

    public ConsistentHashRing(HashFunction hashFunction, int replicas) {
        this.hashFunction = hashFunction;
        this.replicas = replicas;
    }

    @Override
    public void addNode(String node) {
        for (int i = 0; i < replicas; i++) {
            circle.put(hashFunction.hash(node + i), node);
        }
    }

    @Override
    public void removeNode(String node) {
        for (int i = 0; i < replicas; i++) {
            circle.remove(hashFunction.hash(node + i));
        }
    }

    @Override
    public String getNode(String key) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = hashFunction.hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    public List<String> getNodes() {
        return new ArrayList<>(circle.values());
    }
}
