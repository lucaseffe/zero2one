package br.com.zero2one.lucas.products.controller;

import br.com.zero2one.lucas.products.model.Product;
import br.com.zero2one.lucas.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.*;

@RestController
@RequestMapping("/products")

public class ProductsController {

    @Autowired
    private ProductRepository repository;

    private Map<String, Product> products = new HashMap<>();

    @GetMapping
    public Collection<Product> get(){ return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") String id){
        Product product = repository.findById(id).orElse(null);
        if (product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return repository.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){ repository.deleteById(id); }
}
