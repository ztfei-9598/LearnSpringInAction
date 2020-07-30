package com.tangxin.mall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient //服务提供者
@EnableDiscoveryClient //向服务中心注册 理解为发现服务我可以消息 服务消费者
public class MallOrderCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallOrderCloudApplication.class, args);
    }

    @Bean
    @LoadBalanced //开启负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
