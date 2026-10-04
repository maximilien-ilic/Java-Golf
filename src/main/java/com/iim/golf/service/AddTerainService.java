package com.iim.golf.service;

import com.iim.golf.model.Terain;
import com.iim.golf.repository.TerainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddTerainService {

    private final TerainRepository terainRepository;

    @Autowired
    public AddTerainService(TerainRepository terainRepository) {
        this.terainRepository = terainRepository;
    }

    public Terain create(Terain terain) {
        return terainRepository.save(terain);
    }

    public Terain getById(int id) {
        return terainRepository.findById(id).get();
    }
}
