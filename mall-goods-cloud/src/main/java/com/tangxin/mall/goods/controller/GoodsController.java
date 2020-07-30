package com.tangxin.mall.goods.controller;


import com.tangxin.mall.goods.entity.Goods;
import com.tangxin.mall.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author demo
 * @since 2019-06-24
 */
@RestController
@RequestMapping("/goods/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @GetMapping("/list")
    public List<Goods> list() {
        return goodsService.list();
    }

}
