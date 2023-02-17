package com.demo.dao;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class ItemDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column
    private String title;

    @Column(name = "price", scale = 3, precision = 10)
    private BigDecimal price;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
