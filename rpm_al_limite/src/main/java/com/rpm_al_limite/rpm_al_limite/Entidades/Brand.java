package com.rpm_al_limite.rpm_al_limite.Entidades;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBrands;

    @Column(name = "name", nullable = false, length = 100)
    @NonNull
    private String name;

    @Column(name = "description", nullable = false, length = 100)
    @NonNull
    private String description;

    public Integer getIdBrands() {
        return idBrands;
    }

    public void setIdBrands(Integer idBrands) {
        this.idBrands = idBrands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
