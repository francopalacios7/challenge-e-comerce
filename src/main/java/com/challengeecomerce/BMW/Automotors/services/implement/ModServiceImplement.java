package com.challengeecomerce.BMW.Automotors.services.implement;

import com.challengeecomerce.BMW.Automotors.dtos.CarDTO;
import com.challengeecomerce.BMW.Automotors.dtos.ModDTO;
import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.repositories.ModRepository;
import com.challengeecomerce.BMW.Automotors.services.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

@Service
public class ModServiceImplement implements ModService {

    @Autowired
    private ModRepository modRepository;


    @Override
    public Mod findById(Long id) {
        return modRepository.findById(id).orElse(null);
    }

    @Override
    public List<ModDTO> getAllMods() {
        return modRepository.findAll().stream().map(ModDTO::new).collect(Collectors.toList());
    }
}
