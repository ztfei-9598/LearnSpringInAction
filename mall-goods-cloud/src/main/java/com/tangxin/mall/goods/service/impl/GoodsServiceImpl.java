package com.tangxin.mall.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangxin.mall.goods.entity.Goods;
import com.tangxin.mall.goods.mapper.GoodsMapper;
import com.tangxin.mall.goods.service.IGoodsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author demo
 * @since 2019-06-24
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
