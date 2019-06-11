package com.zero2one.desafio_2.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    @Column(name = "request_id")
    @ApiModelProperty("Identificador do pedido")
    private String id;
    @Column(name = "item_id")
    @ApiModelProperty("Identificador do item")
    private String item_id;
    @Column(name = "request_quantity")
    @ApiModelProperty("Quantidade de itens")
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
