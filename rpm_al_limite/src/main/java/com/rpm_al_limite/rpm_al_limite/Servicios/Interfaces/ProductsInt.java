package com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.rpm_al_limite.rpm_al_limite.Entidades.Products;

public interface ProductsInt {

    List<Products> getAllProducts();

    Optional<Products> getProductById(Integer id);

    Products saveProduct(Products product);

    void deleteProduct(Integer id);

    Optional<List<Products>> getProductsByName(String name);
}
