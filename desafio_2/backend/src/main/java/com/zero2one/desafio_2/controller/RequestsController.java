package com.zero2one.desafio_2.controller;

import com.zero2one.desafio_2.model.Request;
import com.zero2one.desafio_2.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/requests")
public class RequestsController {
    @Autowired
    private RequestRepository repository;

    private Map<String, Request> requests = new HashMap<>();

    @GetMapping
    public Collection<Request> get(){ return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") String id){
        Request request = repository.findById(id).orElse(null);
        if (request == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public Request create(@RequestBody Request request){
        return repository.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){ repository.deleteById(id); }
}
