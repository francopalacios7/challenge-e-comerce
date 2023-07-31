package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.CarDTO;
import com.challengeecomerce.BMW.Automotors.dtos.ModDTO;
import com.challengeecomerce.BMW.Automotors.repositories.ModRepository;
import com.challengeecomerce.BMW.Automotors.services.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.
import java.util.Set;
import com.challengeecomerce.BMW.Automotors.models.enums.ModType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ModController {

    @Autowired
    private ModService modService;

    @GetMapping("/mods")
    public ModType[] getAllMods(){
        return ModType.values();
    }
}
