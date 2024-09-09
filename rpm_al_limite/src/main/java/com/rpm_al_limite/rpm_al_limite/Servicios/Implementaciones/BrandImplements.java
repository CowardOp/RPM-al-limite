package com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpm_al_limite.rpm_al_limite.Entidades.Brand;
import com.rpm_al_limite.rpm_al_limite.Repositorios.BrandRepository;
import com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces.BrandsInt;

@Service
public class BrandImplements implements BrandsInt {

    @Autowired
    private BrandRepository repository;

    @Override
    public List<Brand> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Brand> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Brand save(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
