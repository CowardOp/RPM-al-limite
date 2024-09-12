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
    private ProductsRepository productsRepository;

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Optional<Products> getProductById(Integer id) {
        return productsRepository.findById(id);
    }

    @Override
    public Products saveProduct(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productsRepository.deleteById(id);
    }

    @Override
    public Optional<List<Products>> getProductsByName(String name) {
        return productsRepository.findByName(name);
    }
}
