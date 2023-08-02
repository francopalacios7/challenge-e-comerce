package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.ModDTO;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.models.ModType;
import com.challengeecomerce.BMW.Automotors.repositories.ModRepository;
import com.challengeecomerce.BMW.Automotors.repositories.ModTypeRepository;
import com.challengeecomerce.BMW.Automotors.services.ClientService;
import com.challengeecomerce.BMW.Automotors.services.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ModController {

    @Autowired
    private ModService modService;

    @Autowired
    private ModTypeRepository modTypeRepository;

    @Autowired
    private ModRepository modRepository;
    @Autowired
    private ClientService clientService;

    @PostMapping("/admin/addMods")
    public ResponseEntity<Object> addMod(Authentication authentication, @RequestBody ModDTO modDTO) {

//        Client client = clientService.findByEmail(authentication.getName());
//
//
//        if(!client.getEmail().contains("admin")){
//            return new ResponseEntity<>("Only admins can add mods", HttpStatus.FORBIDDEN)
//        }

        if(modDTO.getName().isBlank()){
            return new ResponseEntity<>("Please add a name To the Mod", HttpStatus.FORBIDDEN);
        }

        if(modDTO.getCarColor().toString().isBlank()){
            return new ResponseEntity<>("Please add a color", HttpStatus.FORBIDDEN);
        }

        if(modDTO.getPrice() <= 0){
            return new ResponseEntity<>("Price must be greater than 0", HttpStatus.FORBIDDEN);
        }

        if(modDTO.getStock() <= 0) {
            return new ResponseEntity<>("Stock must be greater than 0", HttpStatus.FORBIDDEN);
        }

        if (modDTO.getDescription().isBlank()){
            return new ResponseEntity<>("Please add a description", HttpStatus.FORBIDDEN);
        }

        if(modDTO.getImages().isEmpty()){
            return new ResponseEntity<>("Please add images for the item", HttpStatus.FORBIDDEN);
        }

        ModType modType = modTypeRepository.findByName(modDTO.getModType());

        if(modType == null){
            modType = new ModType(modDTO.getModType());
            modTypeRepository.save(modType);
        }

        Mod mod = new Mod(modDTO.getName(), modDTO.getDescription(), modDTO.getPrice(), modDTO.getCarColor(), modDTO.getStock(), modDTO.getImages(), modType);
        modService.saveMod(mod);



        return new ResponseEntity<>("Mod Created", HttpStatus.CREATED);
    }

    @PatchMapping("/admin/updateMods")
    public ResponseEntity <Object> updateMods(Authentication authentication, @RequestBody ModDTO modDTO){

//        Client client = clientService.findByEmail(authentication.getName());
        Mod mod = modService.findById(modDTO.getId());

//        if(!client.getEmail().contains("admin")){
//            return new ResponseEntity<>("Only admins can change the mods properties", HttpStatus.FORBIDDEN);
//        }

        if(modDTO.getDescription().isBlank()){
            return new ResponseEntity<>("Please add a description", HttpStatus.FORBIDDEN);
        }

        if (modDTO.getName().isBlank()){
            return new ResponseEntity<>("Please add a name", HttpStatus.FORBIDDEN);
        }

        if (modDTO.getPrice() <= 0){
            return new ResponseEntity<>("Please set a price", HttpStatus.FORBIDDEN);
        }

        if(modDTO.getStock() <= 0){
            return new ResponseEntity<>("Stock must be greater than 0", HttpStatus.FORBIDDEN);
        }

        if (modDTO.getCarColor().toString().isBlank()){
            return new ResponseEntity<>("Color can't be blank", HttpStatus.FORBIDDEN);
        }


        mod.setDescription(modDTO.getDescription());
        mod.setName(modDTO.getName());
        mod.setPrice(modDTO.getPrice());
        mod.setPrice(modDTO.getPrice());
        mod.setCarColor(modDTO.getCarColor());

        modService.saveMod(mod);

        return new ResponseEntity<>("Modified successfully", HttpStatus.OK);

        }

        @PatchMapping("/admin/deleteMods/{id}")
        public ResponseEntity<Object> deleteMod(Authentication authentication, @PathVariable Long id){

//            Client client = clientService.findByEmail(authentication.getName());
            Mod mod = modService.findById(id);

//            if(!client.getEmail().contains("admin")){
//                return new ResponseEntity<>("Only admins can delete mods", HttpStatus.FORBIDDEN);
//            }

            mod.setActive(false);
            modService.saveMod(mod);
            return  new ResponseEntity<>("Mod Deleted", HttpStatus.OK);

        }



    @GetMapping("/modstype")
    public List<ModType> getAllModsType(){
        return modTypeRepository.findAll();

    }
    @GetMapping("/mods")
    public List<Mod> getAllMods(){
        return modRepository.findAll();
    }
}