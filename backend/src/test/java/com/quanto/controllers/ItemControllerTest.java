package com.quanto.controllers;

import com.quanto.dto.ItemDTO;
import com.quanto.services.ItemService;
import com.quanto.utils.Messages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

class ItemControllerTest {

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void mustAddItem() {
        ResponseEntity<String> expected = itemController.addItem(new ItemDTO());
        Assertions.assertThat(expected.getBody()).isEqualTo(Messages.MESSAGE_1.getDescription());
    }

}
