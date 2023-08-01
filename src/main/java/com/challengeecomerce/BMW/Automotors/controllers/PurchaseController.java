package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.DuesPlanDTO;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.DuesPlan;
import com.challengeecomerce.BMW.Automotors.services.ClientService;
import com.challengeecomerce.BMW.Automotors.services.DuesPlanService;
import com.challengeecomerce.BMW.Automotors.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class PurchaseController {
    @Autowired
    private DuesPlanService duesPlanService;
    @Autowired
    private ClientService clientService;
    @PostMapping("/admin/duesPlan")
    public ResponseEntity<Object> createDuesPlan(Authentication authentication, @RequestBody DuesPlanDTO duesPlanDTO) {
        //Client client = clientService.findByEmail(authentication.getName());
        if (duesPlanDTO.getDues().isBlank()) {
            return new ResponseEntity<>("A dues plan must be selected", HttpStatus.FORBIDDEN);
        }
        if (duesPlanDTO.getPlanDescription().isBlank()) {
            return new ResponseEntity<>("A description must be written", HttpStatus.FORBIDDEN);
        }
        if (duesPlanDTO.getInterest().isNaN()) {
            return new ResponseEntity<>("An interest must be selected", HttpStatus.FORBIDDEN);
        }

        DuesPlan duesPlan = new DuesPlan(duesPlanDTO.getPlanDescription(), duesPlanDTO.getDues(), duesPlanDTO.getInterest(), true);
        duesPlanService.save(duesPlan);
        return new ResponseEntity<>("Purchase successful", HttpStatus.ACCEPTED);
    }
    @PatchMapping("/admin/duesPlan")
    public ResponseEntity<Object> deleteDuesPlan(Authentication authentication, DuesPlanDTO duesPlanDTO){
        //Client client = clientService.findByEmail(authentication.getName());
        DuesPlan duesPlan = duesPlanService.findById(duesPlanDTO.getId());
        duesPlan.setActive(false);
        duesPlanService.save(duesPlan);
        return new ResponseEntity<>("Dues plan deleted with success", HttpStatus.ACCEPTED);
    }
    @PutMapping("/admin/duesPlan")
    public ResponseEntity<Object> updateDuesPlan(Authentication authentication, DuesPlanDTO duesPlanDTO){
        //Client client = clientService.findByEmail(authentication.getName());
        DuesPlan duesPlan = duesPlanService.findById(duesPlanDTO.getId());
        if(duesPlanDTO.getDues().isBlank()){
            return new ResponseEntity<>("Dues is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if(duesPlanDTO.getPlanDescription().isBlank()){
            return new ResponseEntity<>("Description is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if(duesPlanDTO.getInterest().isNaN()){
            return new ResponseEntity<>("Interest is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        duesPlan.setDues(duesPlan.getDues());
        duesPlan.setPlanDescription(duesPlan.getPlanDescription());
        duesPlan.setInterest(duesPlan.getInterest());
        duesPlan.setActive(duesPlan.isActive());
        duesPlanService.save(duesPlan);
        return new ResponseEntity<>("Dues plan updated successfully.", HttpStatus.OK);
    }
}