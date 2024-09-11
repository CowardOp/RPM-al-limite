package com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.rpm_al_limite.rpm_al_limite.Entidades.Carts;

public interface CartsInt {
    public List<Carts> findAll();

    public Optional<Carts> findById(Integer id);

    public Carts save(Carts carts);

    public void delete(Integer id);

}
