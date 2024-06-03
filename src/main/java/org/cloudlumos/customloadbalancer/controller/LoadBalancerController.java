package org.cloudlumos.customloadbalancer.controller;

import org.cloudlumos.customloadbalancer.loadbalancer.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoadBalancerController {

    private final LoadBalancer loadBalancer;

    @Autowired
    public LoadBalancerController(LoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
        loadBalancer.addNode("server1");
        loadBalancer.addNode("server2");
        loadBalancer.addNode("server3");
    }

    @GetMapping("/route")
    public String route(@RequestParam String key) {
        return "Request for " + key + " is routed to " + loadBalancer.getNode(key);
    }
}
