package com.demo.dto;

import java.math.BigDecimal;

/**
 * 简单商品信息
 */
public class Item {

    /**
     * 分为单位的价格
     */
    private BigDecimal priceInCent ;

    /**
     * 商品id
     */
    private Long itemId;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 这个是测试
     */
    private String name;

    public BigDecimal getPriceInCent() {
        return priceInCent;
    }

    public void setPriceInCent(BigDecimal priceInCent) {
        this.priceInCent = priceInCent;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
