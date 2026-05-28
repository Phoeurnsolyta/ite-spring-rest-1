package com.ite.spring.rest.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {

    private Long id;
    private String name;
    private String description;
    private Double price;

}
