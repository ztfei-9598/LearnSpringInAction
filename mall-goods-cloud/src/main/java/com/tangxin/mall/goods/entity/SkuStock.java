package com.tangxin.mall.goods.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 商品规格库存关联表
 * </p>
 *
 * @author demo
 * @since 2019-06-24
 */
@TableName("t_sku_stock")
public class SkuStock implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * sku规格id 比如：颜色 尺寸 风格的id
     */
    private Integer skuId;

    /**
     * sku规格id的顺序 颜色->尺寸->风格
     */
    private Integer skuSort;

    /**
     * sku子项id 比如：颜色下的白色
     */
    private Integer skuSubId;

    /**
     * sku子项之间产生的父子关系 比如：白色-中码 白色-大码
     */
    private Integer skuSubParent;

    /**
     * 商品id
     */
    private Integer goodsId;

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }
    public Integer getSkuSort() {
        return skuSort;
    }

    public void setSkuSort(Integer skuSort) {
        this.skuSort = skuSort;
    }
    public Integer getSkuSubId() {
        return skuSubId;
    }

    public void setSkuSubId(Integer skuSubId) {
        this.skuSubId = skuSubId;
    }
    public Integer getSkuSubParent() {
        return skuSubParent;
    }

    public void setSkuSubParent(Integer skuSubParent) {
        this.skuSubParent = skuSubParent;
    }
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "SkuStock{" +
        "skuId=" + skuId +
        ", skuSort=" + skuSort +
        ", skuSubId=" + skuSubId +
        ", skuSubParent=" + skuSubParent +
        ", goodsId=" + goodsId +
        "}";
    }
}
