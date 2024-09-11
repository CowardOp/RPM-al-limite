package com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpm_al_limite.rpm_al_limite.Entidades.Carts;
import com.rpm_al_limite.rpm_al_limite.Repositorios.CartsRepository;
import com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces.CartsInt;

@Service
public class CartImplement implements CartsInt {
    @Autowired
    private CartsRepository repository;

    @Override
    public List<Carts> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Carts> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Carts save(Carts carts) {
        return repository.save(carts);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
