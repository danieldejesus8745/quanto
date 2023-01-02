package com.quanto.controllers;

import com.quanto.dto.ProductDTO;
import com.quanto.services.ProductService;
import com.quanto.utils.Messages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void mustAddProduct() {
        ResponseEntity<String> expected = productController.addProduct(new ProductDTO());
        Assertions.assertThat(expected.getBody()).isEqualTo(Messages.MESSAGE_1.getDescription());
    }

}
