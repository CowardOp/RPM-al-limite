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
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
    @NonNull
    private Categories categoryId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unity_id")
    @NonNull
    private Unity unityId;

}
