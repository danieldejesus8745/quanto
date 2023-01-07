package com.quanto.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Messages {

    MESSAGE_1("Item adicionado com sucesso"),
    MESSAGE_2("Produto já cadastrado");

    private final String description;

}
