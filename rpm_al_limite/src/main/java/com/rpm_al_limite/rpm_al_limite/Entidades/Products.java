package com.rpm_al_limite.rpm_al_limite.Entidades;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducts;

    @Column(name = "name", nullable = false, length = 100)
    @NonNull
    private String name;

    @Column(name = "price", nullable = false, length = 11)
    @NonNull
    private int price;

    @Column(name = "stock", nullable = false, length = 11)
    @NonNull
    private int stock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Categories category_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unity_id")
    private Unity unity_id;

    public Integer getIdProducts() {
        return idproducts;
    }

    public Integer getIdproducts() {
        return idproducts;
    }

    public void setIdproducts(Integer idproducts) {
        this.idproducts = idproducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categories getCategoryId() {
        return category_id;
    }

    public void setCategoryId(Categories category_id) {
        this.category_id = category_id;
    }

    public Unity getUnityId() {
        return unity_id;
    }

    public void setUnityId(Unity unity_id) {
        this.unity_id = unity_id;
    }

}
