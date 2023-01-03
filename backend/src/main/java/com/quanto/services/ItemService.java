package com.quanto.services;

import com.quanto.dto.ItemDTO;
import com.quanto.entities.Item;
import com.quanto.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void addItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setItem(itemDTO.getItem());
        item.setBrand(itemDTO.getBrand());
        item.setLocal(itemDTO.getLocal());
        item.setPrice(itemDTO.getPrice());
        item.setType(itemDTO.getType());
        item.setCreatedAt(LocalDateTime.now());

        itemRepository.save(item);
    }

}
