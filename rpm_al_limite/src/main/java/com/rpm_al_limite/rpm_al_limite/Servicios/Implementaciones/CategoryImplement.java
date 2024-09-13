package com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpm_al_limite.rpm_al_limite.Entidades.Category;
import com.rpm_al_limite.rpm_al_limite.Repositorios.CategoryRepository;
import com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces.CategoryInt;

@Service
public class CategoryImplement implements CategoryInt {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
