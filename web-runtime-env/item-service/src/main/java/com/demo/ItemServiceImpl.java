package com.demo;

import com.demo.converter.ItemConverter;
import com.demo.dao.ItemRepo;
import com.demo.dto.Item;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DubboService(version = "1.0.0", interfaceClass = ItemService.class)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public Item getItemById(Long itemId) {
        return itemRepo.findById(itemId)
                .map(ItemConverter::convertToDTO)
                .orElse(null);
    }

}
