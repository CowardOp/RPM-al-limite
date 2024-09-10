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
import com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones.CategoriesImplements;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    private CategoriesImplements service;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listCategory() {
        return ResponseEntity.ok(service.findAll());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listCategoryById(@PathVariable(value = "id") Integer id) {
        Optional<Categories> category = service.findById(id);
        if (category.isPresent()) {
            return ResponseEntity.ok(category);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crateCategory(@RequestBody Categories category) {
        return ResponseEntity.ok(service.save(category));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editCategory(@RequestBody Categories category) {
        return ResponseEntity.ok(service.save(category));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Optional<Categories> category = service.findById(id);
        if (category.isPresent()) {
            service.delete(id);
            return ResponseEntity.ok(category);
        }
        return ResponseEntity.notFound().build();
    }
}
