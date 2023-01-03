package com.quanto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private Integer id;
    private String item;
    private String brand;
    private String local;
    private double price;
    private String type;
    private LocalDateTime createdAt;

}
