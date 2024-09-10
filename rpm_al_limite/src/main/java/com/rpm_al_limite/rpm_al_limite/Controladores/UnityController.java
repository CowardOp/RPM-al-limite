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

import com.rpm_al_limite.rpm_al_limite.Entidades.Unity;
import com.rpm_al_limite.rpm_al_limite.Servicios.Implementaciones.UnityImplements;

@RestController
@RequestMapping("/api/unity")
public class UnityController {
    @Autowired
    private UnityImplements service;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listUnity() {
        return ResponseEntity.ok(service.findAll());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listUnityById(@PathVariable(value = "id") Integer id) {
        Optional<Unity> unity = service.findById(id);
        if (unity.isPresent()) {
            return ResponseEntity.ok(unity);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crateUnity(@RequestBody Unity unity) {
        return ResponseEntity.ok(service.save(unity));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editUnity(@RequestBody Unity unity) {
        return ResponseEntity.ok(service.save(unity));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Optional<Unity> unity = service.findById(id);
        if (unity.isPresent()) {
            service.delete(id);
            return ResponseEntity.ok(unity);
        }
        return ResponseEntity.notFound().build();
    }

}
