package com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpm_al_limite.rpm_al_limite.Entidades.Unity;
import com.rpm_al_limite.rpm_al_limite.Repositorios.UnityRepository;
import com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces.UnityInt;

@Service
public class UnityImplements implements UnityInt {

    @Autowired
    private UnityRepository repository;

    @Override
    public List<Unity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Unity> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Unity save(Unity unity) {
        return repository.save(unity);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
