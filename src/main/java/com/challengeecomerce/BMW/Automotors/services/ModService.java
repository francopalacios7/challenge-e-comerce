package com.challengeecomerce.BMW.Automotors.services;

import com.challengeecomerce.BMW.Automotors.dtos.ModDTO;
import com.challengeecomerce.BMW.Automotors.models.Mod;

import java.util.Set;

public interface ModService {

    Set<ModDTO> getAllModsDTO();

    void saveMod(Mod mod);
}
