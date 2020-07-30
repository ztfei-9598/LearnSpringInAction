package com.tangxin.mall.goods;

import com.tangxin.mall.goods.entity.Goods;
import com.tangxin.mall.goods.service.IGoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallGoodsCloudApplicationTests {

    @Autowired
    private IGoodsService goodsService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getGoodsById() {
        Goods goods = goodsService.getById(1000);
        System.out.println(goods);
    }

}
