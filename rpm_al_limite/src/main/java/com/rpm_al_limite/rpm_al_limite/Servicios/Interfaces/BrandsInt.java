package com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.rpm_al_limite.rpm_al_limite.Entidades.Brand;

public interface BrandsInt {
    public List<Brand> findAll();

    public Optional<Brand> findById(Integer id);

    public Brand save(Brand brand);

    public void delete(Integer id);
}
