package com.heshi.seckill.entity;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Paosin
 * @version 1.0
 * @className Goods
 * @date 2018/3/17 22:18
 */
@ApiModel("商品信息")
public class Goods {
    @ApiModelProperty(value = "商品id",notes = "流水号")
    private Long id;
    @ApiModelProperty("商品名称")
    private String name;
    @ApiModelProperty("货物剩余数量")
    private int num;
    @ApiModelProperty("商品单价")
    private BigDecimal price;
    @ApiModelProperty("商品介绍")
    private String introduce;
    @ApiModelProperty("商品图片md5")
    private String photo;
    @ApiModelProperty("创建人")
    private User createBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }
}
