package com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.rpm_al_limite.rpm_al_limite.Entidades.User;

public interface UserInt {

    public List<User> findAll();

    public Optional<User> findById(Integer email);

    public User save(User user);

    public void delete(Integer id);
}