package com.tangxin.mall.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 商品规格表
 * </p>
 *
 * @author demo
 * @since 2019-06-24
 */
@TableName("t_sku")
public class Sku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "sku_id", type = IdType.AUTO)
    private Integer skuId;

    /**
     * 规格名称 颜色 尺寸
     */
    private String skuName;

    /**
     * sku父主键id
     */
    private Integer skuParentId;

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
    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }
    public Integer getSkuParentId() {
        return skuParentId;
    }

    public void setSkuParentId(Integer skuParentId) {
        this.skuParentId = skuParentId;
    }
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "Sku{" +
        "skuId=" + skuId +
        ", skuName=" + skuName +
        ", skuParentId=" + skuParentId +
        ", goodsId=" + goodsId +
        "}";
    }
}
