package com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.rpm_al_limite.rpm_al_limite.Entidades.Category;

public interface CategoryInt {

    public List<Category> findAll();

    public Optional<Category> findById(Integer id);

    public Category save(Category category);

    public void delete(Integer id);
}