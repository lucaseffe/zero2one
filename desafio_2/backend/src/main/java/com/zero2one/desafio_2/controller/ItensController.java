package com.zero2one.desafio_2.controller;

import com.zero2one.desafio_2.model.Item;
import com.zero2one.desafio_2.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/itens")

public class ItensController {

    @Autowired
    private ItemRepository repository;

    private Map<String, Item> itens = new HashMap<>();

    @GetMapping
    public Collection<Item> get(){ return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") String id){
        Item item = repository.findById(id).orElse(null);
        if (item == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public Item create(@RequestBody Item item){
        return repository.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){ repository.deleteById(id); }
}
