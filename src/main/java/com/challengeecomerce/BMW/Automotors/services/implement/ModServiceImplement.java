package com.challengeecomerce.BMW.Automotors.services.implement;
import com.challengeecomerce.BMW.Automotors.dtos.ModDTO;
import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.repositories.ModRepository;
import com.challengeecomerce.BMW.Automotors.services.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class ModServiceImplement implements ModService {

    @Autowired
    ModRepository modRepository;

    @Override
    public Mod findById(Long id) {
        return modRepository.findById(id).orElse(null);
    }

    @Override
    public Set<ModDTO> getAllModsDTO() {
        return modRepository.findAll().stream().map(ModDTO::new).collect(Collectors.toSet());
    }

    @Override
    public void saveMod(Mod mod) {
        modRepository.save((mod));
    }

}
