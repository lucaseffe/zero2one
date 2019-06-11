package com.zero2one.desafio_2.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itens")
public class Item {
    @Id
    @Column(name = "item_id")
    @ApiModelProperty("Identificador do item")
    private String id;
    @Column(name = "item_name")
    @ApiModelProperty("Nome do item")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
