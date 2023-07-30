package com.challengeecomerce.BMW.Automotors.services;

import com.challengeecomerce.BMW.Automotors.dtos.ClientDTO;
import com.challengeecomerce.BMW.Automotors.dtos.ModDTO;
import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.Mod;

import java.util.List;

public interface ModService {
    Mod findById(Long id);
    List<ModDTO> getAllMods();
}
