package com.tangxin.mall.goods.controller;


import com.tangxin.mall.goods.entity.Sku;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品规格表 前端控制器
 * </p>
 *
 * @author demo
 * @since 2019-06-24
 */
@RestController
@RequestMapping("/goods/sku")
public class SkuController {




    /**
     * 添加sku数据
     * 颜色：白色 红色
     * 尺寸：大码 中码 小码
     * 风格：欧美 韩国 中国
     *
     * @return
     */
    @GetMapping("/add/{goodsId}")
    public String addSku(@PathVariable int goodsId) {

        return null;



    }



}
