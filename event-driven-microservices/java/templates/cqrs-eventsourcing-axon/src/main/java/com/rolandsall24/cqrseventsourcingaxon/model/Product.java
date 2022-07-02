package com.rolandsall24.cqrseventsourcingaxon.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Product {

    @GeneratedValue
    @Id
    private int productId;
    private String name;
    private long serialNumber;
}
