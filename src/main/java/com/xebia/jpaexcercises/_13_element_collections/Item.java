package com.xebia.jpaexcercises._13_element_collections;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Item {

    private String name;
    private BigDecimal price;

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
