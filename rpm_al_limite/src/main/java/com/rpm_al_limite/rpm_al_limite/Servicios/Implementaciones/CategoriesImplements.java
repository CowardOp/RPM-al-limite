package com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpm_al_limite.rpm_al_limite.Entidades.Categories;
import com.rpm_al_limite.rpm_al_limite.Repositorios.CategoriesRepository;
import com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces.CategoriesInt;

@Service
public class CategoriesImplements implements CategoriesInt {

    @Autowired
    private CategoriesRepository repository;

    @Override
    public List<Categories> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Categories> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Categories save(Categories categories) {
        return repository.save(categories);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
