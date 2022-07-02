package com.rolandsall24.cqrseventsourcingaxon.product.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class CreateProductCommand {

    private String name;
    private long serialNumber;

}
