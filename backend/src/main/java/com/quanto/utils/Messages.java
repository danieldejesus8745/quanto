package com.quanto.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Messages {

    MESSAGE_1("Item adicionado com sucesso"),
    MESSAGE_2("Item já adicionado anteriormente");

    private final String description;

}
