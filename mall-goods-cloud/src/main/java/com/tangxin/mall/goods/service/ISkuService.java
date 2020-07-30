package com.tangxin.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tangxin.mall.goods.entity.Sku;

/**
 * <p>
 * 商品规格表 服务类
 * </p>
 *
 * @author demo
 * @since 2019-06-24
 */
public interface ISkuService extends IService<Sku> {
    void addSku(int goodsId);
}
