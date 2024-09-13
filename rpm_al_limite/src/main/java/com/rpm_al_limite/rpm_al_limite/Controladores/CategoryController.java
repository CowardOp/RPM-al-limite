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

import com.rpm_al_limite.rpm_al_limite.Entidades.Category;
import com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones.CategoryImplement;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryImplement service;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listCategory() {
        return ResponseEntity.ok(service.findAll());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("./{id}")
    public ResponseEntity<?> listCategoryById(@PathVariable(value = "id") Integer id) {
        Optional<Category> category = service.findById(id);
        if (category.isPresent()) {
            return ResponseEntity.ok(category);
        }

        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(service.save(category));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editCategory(@RequestBody Category category) {
        return ResponseEntity.ok(service.save(category));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Optional<Category> category = service.findById(id);
        if (category.isPresent()) {
            service.delete(id);
            return ResponseEntity.ok(category);
        }
        return ResponseEntity.notFound().build();
    }

}
