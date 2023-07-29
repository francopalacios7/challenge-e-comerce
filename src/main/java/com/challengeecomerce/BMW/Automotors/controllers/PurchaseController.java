package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.DuesPlanDTO;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.DuesPlan;
import com.challengeecomerce.BMW.Automotors.services.ClientService;
import com.challengeecomerce.BMW.Automotors.services.DuesPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PurchaseController {
    @Autowired
    private DuesPlanService duesPlanService;
    @Autowired
    private ClientService clientService;
    @PostMapping("/admin/duesPlan")
    public ResponseEntity<Object> createDuesPlan(Authentication authentication, @RequestBody DuesPlanDTO duesPlanDTO){
        Client client = clientService.findByEmail(authentication.getName());
        if (duesPlanDTO.getDues().isBlank()){
            return new ResponseEntity<>("A dues plan must be selected", HttpStatus.FORBIDDEN);
        }
        if (duesPlanDTO.getPlanDescription().isBlank()) {
            return new ResponseEntity<>("A description must be written", HttpStatus.FORBIDDEN);
        }
        if (duesPlanDTO.getInterest().isNaN()){
            return new ResponseEntity<>("An interest must be selected", HttpStatus.FORBIDDEN);
        }
        DuesPlan duesPlan = new DuesPlan(duesPlanDTO.getPlanDescription(), duesPlanDTO.getDues(), duesPlanDTO.getInterest());
        duesPlanService.save(duesPlan);
        return new ResponseEntity<>("Purchase successful", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/admin/duesPlan")
    public ResponseEntity<Object> deleteDuesPlan(Authentication authentication, DuesPlanDTO duesPlanDTO){
        Client client = clientService.findByEmail(authentication.getName());
        DuesPlan duesPlan = duesPlanService.findById(duesPlanDTO.getId());
        duesPlanService.delete(duesPlan);
        return new ResponseEntity<>("Dues plan deleted with success", HttpStatus.ACCEPTED);
    }
}