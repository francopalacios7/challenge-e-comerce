package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.models.enums.ModType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ModController {
    @GetMapping("/mods")
    public ModType[] getAllMods(){
        return ModType.values();
    }
}
