package com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.rpm_al_limite.rpm_al_limite.Entidades.Categories;

public interface CategoriesInt {

    public List<Categories> findAll();

    public Optional<Categories> findById(Integer id);

    public Categories save(Categories categories);

    public void delete(Integer id);
}
