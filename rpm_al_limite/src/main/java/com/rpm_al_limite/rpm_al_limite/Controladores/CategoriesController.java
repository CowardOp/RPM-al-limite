package com.rpm_al_limite.rpm_al_limite.Controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpm_al_limite.rpm_al_limite.Entidades.Categories;
import com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones.CategoriesImplement;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    private CategoriesImplement service;

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listCategoryById(@PathVariable(value = "id") Integer id) {
        Optional<Categories> categories = service.findById(id);
        if (categories.isPresent()) {
            return ResponseEntity.ok(categories);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Categories categories) {
        return ResponseEntity.ok(service.save(categories));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editCategory(@RequestBody Categories categories) {
        return ResponseEntity.ok(service.save(categories));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Optional<Categories> categories = service.findById(id);
        if (categories.isPresent()) {
            service.delete(id);
            return ResponseEntity.ok(categories);
        }
        return ResponseEntity.notFound().build();
    }
}
