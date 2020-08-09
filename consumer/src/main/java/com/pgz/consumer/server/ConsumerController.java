package com.pgz.consumer.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者
 *
 * @author liquan_pgz@qq.com
 * @date 2020-08-09
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("ribbonConsumer")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://hello-service/index", String.class).getBody();
    }
}
