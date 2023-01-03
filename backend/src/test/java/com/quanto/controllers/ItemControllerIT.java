package com.quanto.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void mustAddProduct() throws Exception {
        mockMvc.perform(post("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"description\": \"Test description\"," +
                                "    \"brand\": \"Test brand\"," +
                                "    \"type\": \"unit\"," +
                                "    \"price\": 15.45" +
                                "}"))
                .andExpect(status().isCreated());
    }

}
