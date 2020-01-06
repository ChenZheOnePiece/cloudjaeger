package cn.com.taiji.consume.web;

import cn.com.taiji.consume.feign.DcClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
    private static Logger log = LoggerFactory.getLogger(DcController.class);
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    DcClientService dcClient;

    @GetMapping("/consumer")
    public String dc() {
        log.info("feign-consumer");
        return dcClient.consumer();
    }
}
