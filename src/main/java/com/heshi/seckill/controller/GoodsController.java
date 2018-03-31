package com.heshi.seckill.controller;

import com.heshi.seckill.common.Message;
import com.heshi.seckill.entity.Goods;
import com.heshi.seckill.service.GoodsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author Paosin
 * @version 1.0
 * @className GoodsController
 * @date 2018/3/30 23:44
 */
@Api("商品Api")
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Autowired
    private GoodsService goodsService;

    @ApiOperation("获取商品")
    @GetMapping("/{id}")
    public Message getGoods(@PathVariable Long id) {
        Goods goods = this.goodsService.get(id);
        if (Objects.isNull(goods)) {
            return new Message(HttpStatus.BAD_REQUEST, "商品不存在", null);
        }
        return Message.getSuccess(null, goods);
    }

    @PostMapping
    public Message saveGoods(Goods goods) {
        if (this.goodsService.save(goods) > 0) {
            return Message.getSuccess("保存商品成功");
        }
        return new Message(HttpStatus.BAD_REQUEST, "保存商品失败", null);
    }

    @ApiOperation("更新商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的商品编号", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "goods", value = "更新的商品信息",required = true,dataType = "Goods")
    })
    @PutMapping("/{id}")
    public Message updateGoods(@PathVariable Long id,
                               Goods goods) {
        if (this.goodsService.update(goods) > 0) {
            return Message.getSuccess("修改商品信息成功");
        }
        return new Message(HttpStatus.BAD_REQUEST, "保存商品失败", null);
    }
}
