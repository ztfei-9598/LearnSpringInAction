package com.tangxin.mall.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 商品库存表
 * </p>
 *
 * @author demo
 * @since 2019-06-24
 */
@TableName("t_stock")
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "stock_id", type = IdType.AUTO)
    private Integer stockId;

    /**
     * sku编号 3133817
     */
    private String stockNo;

    /**
     * 库存
     */
    private Integer stockNum;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * sku关联列表id 白色-中码-欧美的sku_id
     */
    private String skuIds;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }
    public String getStockNo() {
        return stockNo;
    }

    public void setStockNo(String stockNo) {
        this.stockNo = stockNo;
    }
    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    public String getSkuIds() {
        return skuIds;
    }

    public void setSkuIds(String skuIds) {
        this.skuIds = skuIds;
    }

    @Override
    public String toString() {
        return "Stock{" +
        "stockId=" + stockId +
        ", stockNo=" + stockNo +
        ", stockNum=" + stockNum +
        ", goodsId=" + goodsId +
        ", skuIds=" + skuIds +
        "}";
    }
}
