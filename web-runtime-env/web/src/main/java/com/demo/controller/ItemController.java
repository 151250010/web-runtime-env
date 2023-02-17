package com.demo.controller;

import com.demo.ItemService;
import com.demo.dto.Item;
import com.demo.view.ItemVO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @DubboReference
    private ItemService itemService;

    @GetMapping("/get")
    public ItemVO getItem(@RequestParam Long itemId) {
        Item item = itemService.getItemById(itemId);
        ItemVO itemVO = new ItemVO();
        itemVO.setItemId(item.getItemId());
        itemVO.setTitle(item.getTitle());
        itemVO.setPriceStr(item.getPriceInCent().toString());
        return itemVO;
    }

}
