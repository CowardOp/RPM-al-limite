package com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpm_al_limite.rpm_al_limite.Repositorios.UserRepository;
import com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces.UserInt;
import com.rpm_al_limite.rpm_al_limite.Entidades.User;

@Service
public class UserImplement implements UserInt {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<List<User>> buscar(String texto) {
        return repository.findByEmail("%" + texto + "%");
    }

    @Override
    public Optional<User> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
