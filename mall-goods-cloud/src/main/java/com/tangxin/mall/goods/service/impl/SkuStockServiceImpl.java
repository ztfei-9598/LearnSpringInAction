package com.tangxin.mall.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangxin.mall.goods.entity.SkuStock;
import com.tangxin.mall.goods.mapper.SkuStockMapper;
import com.tangxin.mall.goods.service.ISkuStockService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品规格库存关联表 服务实现类
 * </p>
 *
 * @author demo
 * @since 2019-06-24
 */
@Service
public class SkuStockServiceImpl extends ServiceImpl<SkuStockMapper, SkuStock> implements ISkuStockService {

}
