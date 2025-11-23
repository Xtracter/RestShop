package com.crazedout.restshop.service;

import com.crazedout.restshop.model.ShopModel;
import com.crazedout.restshop.repository.RESTRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RESTService {

    private final RESTRepository repo;

    public RESTService(RESTRepository repo) {
        this.repo = repo;
    }

    public List<ShopModel> findAll() { return repo.findAll(); }
    public Optional<ShopModel> findById(Long id) { return repo.findById(id); }
    public ShopModel save(ShopModel model) { return repo.save(model); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
