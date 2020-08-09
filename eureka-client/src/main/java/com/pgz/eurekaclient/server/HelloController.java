package com.pgz.eurekaclient.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author liquan_pgz@qq.com
 * @date 2020-08-09
 */
@RestController
public class HelloController {

    //服务注册
    @Autowired
    private Registration registration;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("index")
    public String index() {
        List<ServiceInstance> instances = discoveryClient.getInstances(registration.getServiceId());
        ServiceInstance instance;
        if (instances != null && !instances.isEmpty()) {
            for (ServiceInstance serviceInstance : instances) {
                int port = serviceInstance.getPort();
                if (port == 5000) {
                    instance = serviceInstance;
                    System.out.println(instance.getMetadata());
                }
            }
        }

        return "Hello World";
    }
}
