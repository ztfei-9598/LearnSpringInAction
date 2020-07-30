package com.tangxin.mall.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangxin.mall.goods.entity.Stock;
import com.tangxin.mall.goods.mapper.StockMapper;
import com.tangxin.mall.goods.service.IStockService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品库存表 服务实现类
 * </p>
 *
 * @author demo
 * @since 2019-06-24
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {

}
