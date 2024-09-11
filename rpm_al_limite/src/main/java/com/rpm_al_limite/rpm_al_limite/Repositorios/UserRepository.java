package com.rpm_al_limite.rpm_al_limite.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpm_al_limite.rpm_al_limite.Entidades.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}