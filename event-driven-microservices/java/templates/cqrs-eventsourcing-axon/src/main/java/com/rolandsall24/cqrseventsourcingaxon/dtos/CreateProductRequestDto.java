package com.rolandsall24.cqrseventsourcingaxon.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductRequestDto {

    private String name;
    private long serialNumber;

}
