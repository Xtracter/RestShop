package com.crazedout.restshop.controller;

import com.crazedout.restshop.model.ShopModel;
import com.crazedout.restshop.service.RESTService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/restshop")
@SuppressWarnings("unused")
public class RESTController {
    private final RESTService service;

    public RESTController(RESTService service) {
        this.service = service;
    }

    @GetMapping
    public List<ShopModel> list() { return service.findAll(); }

    @GetMapping("{id}")
    public ResponseEntity<ShopModel> get(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ShopModel> create(@Valid @RequestBody ShopModel model) {
        ShopModel saved = service.save(model);
        return ResponseEntity.created(URI.create("/api/restshop/" + saved.getId())).body(saved);
    }

    @PutMapping("{id}")
    public ResponseEntity<ShopModel> update(@PathVariable Long id, @Valid @RequestBody ShopModel model) {
        return service.findById(id).map(existing -> {
            existing.setTitle(model.getTitle());
            existing.setDescription(model.getDescription());
            existing.setCompleted(model.isCompleted());
            ShopModel updated = service.save(existing);
            return ResponseEntity.ok(updated);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id).map(existing -> {
            service.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
