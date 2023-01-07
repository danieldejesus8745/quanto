package com.quanto.services;

import com.quanto.dto.ItemDTO;
import com.quanto.entities.Item;
import com.quanto.repositories.ItemRepository;
import com.quanto.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

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

        checkIfThisItemHasAlreadyBeenAdded(item);

        itemRepository.save(item);
    }

    private void checkIfThisItemHasAlreadyBeenAdded(Item item) {
        Item persisted = itemRepository.findByItemAndBrandAndLocalAndPriceAndType(
                item.getItem(),
                item.getBrand(),
                item.getLocal(),
                item.getPrice(),
                item.getType()
        ).orElse(null);

        if (Objects.nonNull(persisted)) throw new IllegalStateException(Messages.MESSAGE_2.getDescription());
    }

}
