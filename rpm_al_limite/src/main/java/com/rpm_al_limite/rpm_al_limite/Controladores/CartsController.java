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

import com.rpm_al_limite.rpm_al_limite.Entidades.Carts;
import com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones.CartImplement;

@RestController
@RequestMapping("/api/cart")
public class CartsController {

    @Autowired
    private CartImplement service;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listCart() {
        return ResponseEntity.ok(service.findAll());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listCartById(@PathVariable(value = "id") Integer id) {
        Optional<Carts> carts = service.findById(id);
        if (carts.isPresent()) {
            return ResponseEntity.ok(carts);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crateCarts(@RequestBody Carts carts) {
        return ResponseEntity.ok(service.save(carts));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editCarts(@RequestBody Carts carts) {
        return ResponseEntity.ok(service.save(carts));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Optional<Carts> carts = service.findById(id);
        if (carts.isPresent()) {
            service.delete(id);
            return ResponseEntity.ok(carts);
        }
        return ResponseEntity.notFound().build();
    }

}
