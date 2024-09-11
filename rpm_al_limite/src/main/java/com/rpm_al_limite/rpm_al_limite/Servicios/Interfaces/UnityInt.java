package com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.rpm_al_limite.rpm_al_limite.Entidades.Unity;

public interface UnityInt {
    public List<Unity> findAll();

    public Optional<Unity> findById(Integer id);

    public Unity save(Unity unity);

    public void delete(Integer id);
}
