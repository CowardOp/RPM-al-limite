package com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpm_al_limite.rpm_al_limite.Entidades.Products;
import com.rpm_al_limite.rpm_al_limite.Repositorios.ProductsRepository;
import com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces.ProductsInt;

@Service
public class ProductsImplement implements ProductsInt {

    @Autowired
    private ProductsRepository repository;

    @Override
    public List<Products> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<List<Products>> buscar(String texto) {
        return repository.findByNameLikeOrCreatedAt("%" + texto + "%", texto);
    }

    @Override
    public Optional<Products> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Products save(Products products) {
        return repository.save(products);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
        ;
    }

}
