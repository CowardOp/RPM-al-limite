package com.rpm_al_limite.rpm_al_limite.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rpm_al_limite.rpm_al_limite.Entidades.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<List<User>> findByEmail(String email);
}