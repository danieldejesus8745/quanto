package com.quanto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100)
    private String item;
    @Column(length = 50)
    private String brand;
    @Column(length = 20)
    private String local;
    private double price;
    @Column(length = 5)
    private String type;
    private LocalDateTime createdAt;

}
