package com.rpm_al_limite.rpm_al_limite.Controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping
    public ResponseEntity<?> listProductById(@PathVariable(value = "id") Integer id) {
        Optional<Products> products = service.findById(id);
        if (products.isPresent()) {
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> createProduct(@RequestBody Products products) {
        return ResponseEntity.ok(service.save(products));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Optional<Products> products = service.findById(id);
        if (products.isPresent()) {
            service.delete(id);
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.notFound().build();
    }

}
