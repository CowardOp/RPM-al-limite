package com.rpm_al_limite.rpm_al_limite.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rpm_al_limite.rpm_al_limite.Entidades.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

    Optional<List<Products>> findByName(String name);

}
