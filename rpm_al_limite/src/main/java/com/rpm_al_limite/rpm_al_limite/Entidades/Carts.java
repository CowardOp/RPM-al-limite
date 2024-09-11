package com.rpm_al_limite.rpm_al_limite.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;

@Entity
@Table(name = "carts")
public class Carts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcarts;

    @Column(name = "created_at", nullable = false)
    @NonNull
    private LocalDate created_at;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user_id;

    public Integer getIdcarts() {
        return idcarts;
    }

    public void setIdcarts(Integer idcarts) {
        this.idcarts = idcarts;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public User getUserId() {
        return user_id;
    }

    public void setUserId(User user_id) {
        this.user_id = user_id;
    }

}
