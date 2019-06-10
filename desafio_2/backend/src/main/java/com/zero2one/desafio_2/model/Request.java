package com.zero2one.desafio_2.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Request {
    @Id
    @Column(name = "request_id")
    private String id;
    @Column(name = "item_id")
    private String item_id;
    @Column(name = "request_quantity")
    private Integer quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
