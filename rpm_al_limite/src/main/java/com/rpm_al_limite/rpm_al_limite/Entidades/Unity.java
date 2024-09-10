package com.rpm_al_limite.rpm_al_limite.Entidades;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unity")
public class Unity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idunity;

    @Column(name = "name", nullable = false, length = 100)
    @NonNull
    private String name;

    public Integer getIdunity() {
        return idunity;
    }

    public void setIdunity(Integer idunity) {
        this.idunity = idunity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
