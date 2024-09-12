package com.rpm_al_limite.rpm_al_limite.Controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpm_al_limite.rpm_al_limite.Entidades.Products;
import com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones.ProductsImplement;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsImplement service;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listProducts() {
        return ResponseEntity.ok(service.findAll());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listProductById(@PathVariable(value = "id") Integer id) {
        Optional<Products> products = service.findById(id);
        if (products.isPresent()) {
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Products products) {
        return ResponseEntity.ok(service.save(products));
    }

    @CrossOrigin(origins = "*")
    @PatchMapping
    public ResponseEntity<?> searchProducts(@RequestBody Products products) {
        return ResponseEntity.ok(service.buscar(products.getName()));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editProducts(@RequestBody Products products) {
        return ResponseEntity.ok(service.save(products));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Optional<Products> products = service.findById(id);
        if (products.isPresent()) {
            service.delete(id);
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.notFound().build();
    }

}
