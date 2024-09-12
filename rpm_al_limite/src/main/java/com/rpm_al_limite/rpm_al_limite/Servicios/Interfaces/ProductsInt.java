package com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.rpm_al_limite.rpm_al_limite.Entidades.Products;

public interface ProductsInt {

    public List<Products> findAll();

    public Optional<Products> findById(Integer id);

    public Products save(Products products);

    public void delete(Integer id);

    public Optional<List<Products>> buscar(String name);
}
