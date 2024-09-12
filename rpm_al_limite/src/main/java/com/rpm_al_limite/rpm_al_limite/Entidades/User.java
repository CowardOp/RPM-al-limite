package com.rpm_al_limite.rpm_al_limite.Entidades;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iduser;

    @Column(name = "name", nullable = false, length = 100)
    @NonNull
    private String name;

    @Column(name = "email", nullable = false, length = 255, unique = true)
    @NonNull
    private String email;

    @Column(name = "password", nullable = false, length = 25)
    @NonNull
    private String password;

    @Column(name = "phone", nullable = false, length = 25)
    @NonNull
    private String phone;

    @Column(name = "address", nullable = false, length = 100)
    @NonNull
    private String address;

    @Column(name = "created_at", nullable = false)
    @NonNull
    private LocalDate created_at;

}