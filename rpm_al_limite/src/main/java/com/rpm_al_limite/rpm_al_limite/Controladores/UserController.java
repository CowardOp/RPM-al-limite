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

import com.rpm_al_limite.rpm_al_limite.Entidades.User;
import com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones.UserImplement;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserImplement service;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listUser() {
        return ResponseEntity.ok(service.findAll());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listUserById(@PathVariable(value = "id") Integer id) {
        Optional<User> user = service.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crateUser(@RequestBody User user) {
        return ResponseEntity.ok(service.save(user));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editUser(@RequestBody User user) {
        return ResponseEntity.ok(service.save(user));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Optional<User> user = service.findById(id);
        if (user.isPresent()) {
            service.delete(id);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
}
