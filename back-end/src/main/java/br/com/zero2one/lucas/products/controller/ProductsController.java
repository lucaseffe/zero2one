package br.com.zero2one.lucas.products.controller;

import br.com.zero2one.lucas.products.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")

public class ProductsController {

    private Map<String, Product> products = new HashMap<>();

    public ProductsController(){
        Product celular = new Product();
        celular.setId("1A");
        celular.setName("Moto X");
        celular.setDescription("Novo Moto X2");
        celular.setPrice(1999.99);
        products.put("1A", celular);
    }

    @GetMapping
    public Collection<Product> get(){ return products.values(); }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") String id){
        return products.get(id);
    }
}
