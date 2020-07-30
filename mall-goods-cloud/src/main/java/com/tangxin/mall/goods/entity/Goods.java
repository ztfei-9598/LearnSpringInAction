package com.tangxin.mall.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author demo
 * @since 2019-06-24
 */
@TableName("t_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    /**
     * 商品编号
     */
    private String goodsNo;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格 单位分
     */
    private Long goodsPrice;

    /**
     * 商品详情富文本
     */
    private String goodsDetail;

    /**
     * 轮播图
     */
    private String goodsCarousel;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }
    public String getGoodsCarousel() {
        return goodsCarousel;
    }

    public void setGoodsCarousel(String goodsCarousel) {
        this.goodsCarousel = goodsCarousel;
    }

    @Override
    public String toString() {
        return "Goods{" +
        "goodsId=" + goodsId +
        ", goodsNo=" + goodsNo +
        ", goodsName=" + goodsName +
        ", goodsPrice=" + goodsPrice +
        ", goodsDetail=" + goodsDetail +
        ", goodsCarousel=" + goodsCarousel +
        "}";
    }
}
