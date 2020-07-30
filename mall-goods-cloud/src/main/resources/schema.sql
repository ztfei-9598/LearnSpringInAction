
-- create database if not exists mall character set utf8 collate utf8_general_ci;

use mall;


create table if not exists t_goods
(
    goods_id       int(11) primary key not null auto_increment comment '主键id',
    goods_no       varchar(32)         not null comment '商品编号',
    goods_name     varchar(32)         not null comment '商品名称',
    goods_price    bigint              not null comment '商品价格 单位分',
    goods_detail   text                null comment '商品详情富文本',
    goods_carousel varchar(500) comment '轮播图'
) engine=InnoDB default charset=utf8 comment '商品表';

create table if not exists t_sku
(
    sku_id        int(11) primary key not null auto_increment comment '主键id',
    sku_name      varchar(32)         not null comment '规格名称 颜色 尺寸',
    sku_parent_id int(11)             not null comment 'sku父主键id',
    goods_id      int(11)             not null comment '商品id'
) engine=InnoDB default charset=utf8 comment '商品规格表';


create table if not exists t_stock
(
    stock_id  int(11) primary key not null auto_increment comment '主键id',
    stock_no  varchar(32)         not null comment 'sku编号 3133817',
    stock_num int(11)             not null comment '库存',
    goods_id  int(11)             not null comment '商品id',
    sku_ids   varchar(100)        not null comment 'sku关联列表id 白色-中码-欧美的sku_id'
) engine=InnoDB default charset=utf8  comment '商品库存表';


create table if not exists t_sku_stock
(
    id             int(11) primary key not null auto_increment comment '主键id',
    sku_id         int(11)             not null comment 'sku规格id 比如：颜色 尺寸 风格的id',
    sku_sort       int                 not null comment 'sku规格id的顺序 颜色->尺寸->风格',
    sku_sub_id     int(11)             not null comment 'sku子项id 比如：颜色下的白色',
    sku_sub_parent int(11)             not null comment 'sku子项之间产生的父子关系 比如：白色-中码 白色-大码',
    goods_id       int(11)             not null comment '商品id'
) engine=InnoDB default charset=utf8  comment '商品规格库存关联表';