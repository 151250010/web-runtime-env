package com.demo.converter;

import com.demo.dao.ItemDO;
import com.demo.dto.Item;

public class ItemConverter {

    public static Item convertToDTO(ItemDO itemDO) {
        Item item = new Item();
        item.setItemId(itemDO.getItemId());
        item.setTitle(itemDO.getTitle());
        item.setPriceInCent(itemDO.getPrice());
        return item;
    }
}
