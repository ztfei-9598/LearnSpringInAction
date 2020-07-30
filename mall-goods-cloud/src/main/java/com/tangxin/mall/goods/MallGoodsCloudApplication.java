package com.tangxin.mall.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //服务提供者
@MapperScan("com.tangxin.mall.goods.mapper")
public class MallGoodsCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallGoodsCloudApplication.class, args);
    }

}
