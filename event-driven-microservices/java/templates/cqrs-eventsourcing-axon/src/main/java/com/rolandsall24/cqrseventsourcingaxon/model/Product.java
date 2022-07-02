package com.rolandsall24.cqrseventsourcingaxon.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Product {


    @Id
    private UUID productId;
    private String name;
    private long serialNumber;
}
