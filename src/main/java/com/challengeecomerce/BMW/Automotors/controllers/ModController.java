package com.challengeecomerce.BMW.Automotors.controllers;

<<<<<<< HEAD
import com.challengeecomerce.BMW.Automotors.dtos.ModDTO;
import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.services.ClientService;
import com.challengeecomerce.BMW.Automotors.services.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
=======
import com.challengeecomerce.BMW.Automotors.models.enums.ModType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> cd42151eef4bf8910bbfca607ce7bcadf4247b05

@RestController
@RequestMapping("/api")
public class ModController {
<<<<<<< HEAD

    @Autowired
    private ModService modService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/mods")
    public Set<ModDTO> getAll() { return modService.getAllModsDTO();}

    @PostMapping("/admin/mods")
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

        Mod mod = new Mod(modDTO.getName(), modDTO.getDescription(), modDTO.getPrice(), modDTO.getCarColor(), modDTO.getStock(), modDTO.getImages());
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

=======
    @GetMapping("/mods")
    public ModType[] getAllMods(){
        return ModType.values();
    }
>>>>>>> cd42151eef4bf8910bbfca607ce7bcadf4247b05
}
