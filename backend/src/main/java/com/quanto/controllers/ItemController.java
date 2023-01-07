package com.quanto.controllers;

import com.quanto.dto.ItemDTO;
import com.quanto.services.ItemService;
import com.quanto.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/itens")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<String> addItem(@RequestBody ItemDTO itemDTO) {
        try {
            itemService.addItem(itemDTO);
        } catch (IllegalStateException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(Messages.MESSAGE_1.getDescription());
    }

}
