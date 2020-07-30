package com.tangxin.mall.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangxin.mall.goods.entity.Sku;
import com.tangxin.mall.goods.mapper.SkuMapper;
import com.tangxin.mall.goods.service.ISkuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 商品规格表 服务实现类
 * </p>
 *
 * @author demo
 * @since 2019-06-24
 */
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements ISkuService {


    /**
     * 添加sku数据
     *      * 颜色：白色 红色
     *      * 尺寸：大码 中码 小码
     *      * 风格：欧美 韩国 中国
     * @param goodsId
     */
    @Transactional(rollbackFor = Exception.class)
    public void addSku(int goodsId) {
        //颜色
        Sku colorSku = new Sku();
        colorSku.setSkuName("颜色");
        colorSku.setSkuParentId(0);
        colorSku.setGoodsId(goodsId);
        save(colorSku);

        //尺寸
        Sku sizeSku = new Sku();
        sizeSku.setSkuName("尺寸");
        sizeSku.setSkuParentId(0);
        sizeSku.setGoodsId(goodsId);
        save(sizeSku);

        //风格
        Sku styleSku = new Sku();
        styleSku.setSkuName("风格");
        styleSku.setSkuParentId(0);
        sizeSku.setGoodsId(goodsId);
        save(styleSku);


        Sku whiteSku = new Sku();
        whiteSku.setSkuName("白色");
        whiteSku.setSkuParentId(colorSku.getSkuId());

        Sku redSku = new Sku();
        redSku.setSkuName("红色");
        redSku.setSkuParentId(colorSku.getSkuId());


        Sku largeSku = new Sku();
        largeSku.setSkuName("大码");
        largeSku.setSkuParentId(sizeSku.getSkuId());


        Sku middleSku = new Sku();
        middleSku.setSkuName("中码");
        middleSku.setSkuParentId(sizeSku.getSkuId());

        Sku smallSku = new Sku();
        smallSku.setSkuName("小码");
        smallSku.setSkuParentId(sizeSku.getSkuId());


        Sku eaSku = new Sku();
        eaSku.setSkuName("欧美");
        eaSku.setSkuParentId(styleSku.getSkuId());

        Sku koreaSku = new Sku();
        koreaSku.setSkuName("韩国");
        koreaSku.setSkuParentId(styleSku.getSkuId());


        Sku chinaSku = new Sku();
        chinaSku.setSkuName("中国");
        chinaSku.setSkuParentId(styleSku.getSkuId());







    }


}
