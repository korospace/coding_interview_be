package com.korospace.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotEmpty(message = "id is required")
    private String id;

    @Column(name="product_name",unique=true,columnDefinition = "text default NULL")
    @NotEmpty(message = "name is required")
    private String name; 

    @NotNull(message = "price is required")
    private Long price;

    @NotNull(message = "quantity is required")
    private Integer quantity;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;

    public Product() {
    }

    public Product(String id, String name, Long price, Integer quantity, Date created_at, Date updated_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}