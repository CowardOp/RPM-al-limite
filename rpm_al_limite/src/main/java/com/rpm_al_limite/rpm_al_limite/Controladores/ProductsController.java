package com.rpm_al_limite.rpm_al_limite.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rpm_al_limite.rpm_al_limite.Entidades.Products;
import com.rpm_al_limite.rpm_al_limite.Servicios.Interfaces.ProductsInt;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    @Autowired
    private ProductsInt productsService;

    @GetMapping
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Integer id) {
        Optional<Products> product = productsService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Products createProduct(@RequestBody Products product) {
        return productsService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Integer id, @RequestBody Products product) {
        if (productsService.getProductById(id).isPresent()) {
            product.setIdproducts(id);
            return ResponseEntity.ok(productsService.saveProduct(product));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        if (productsService.getProductById(id).isPresent()) {
            productsService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Products>> getProductsByName(@RequestParam String name) {
        Optional<List<Products>> products = productsService.getProductsByName(name);
        return products.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
