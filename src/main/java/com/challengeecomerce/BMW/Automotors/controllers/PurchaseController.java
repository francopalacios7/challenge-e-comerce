package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.DuesPlanDTO;
import com.challengeecomerce.BMW.Automotors.dtos.DuesPlanPDFExporterDTO;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.DuesPlan;
import com.challengeecomerce.BMW.Automotors.models.MeetingReservation;
import com.challengeecomerce.BMW.Automotors.repositories.DuesPlanRepository;
import com.challengeecomerce.BMW.Automotors.services.ClientService;
import com.challengeecomerce.BMW.Automotors.services.DuesPlanService;
import com.challengeecomerce.BMW.Automotors.services.PurchaseService;
import com.challengeecomerce.BMW.Automotors.utils.DuesPlanPDFExporter;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

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



    @PostMapping(path = "/purchase/duesPlanPDF")
    public void transactionsPDF(HttpServletResponse response, @RequestBody DuesPlanPDFExporterDTO duesPlan) throws DocumentException, IOException {
//        Client client = clientService.findByEmail(authentication.getName());
//        if (client == null){
//            return new ResponseEntity<>("The Client does not exist", HttpStatus.FORBIDDEN);
//        }

        DuesPlan duesPlanToPrint = duesPlanService.findById(duesPlan.getId());

// Crea una lista de DuesPlan y agrega el objeto duesPlanToPrint a la lista
        List<DuesPlan> listDuesPlan = new ArrayList<>();
        listDuesPlan.add(duesPlanToPrint);

//        Client clientOwnTransactions = accountToPrint.getClient();
        response.setContentType("application/pdf");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//        String currentDateTime = dateFormat.format(new Date());
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=transactions"+currentDateTime + ".pdf";

//        List<Transaction> listTransactions = this.transactionService.getTransactionsByDate(date.getLocalDateTimeStart(),date.getLocalDateTimeEnd(),accountToPrint);
        DuesPlanPDFExporter exporter = new DuesPlanPDFExporter(listDuesPlan );
        exporter.export(response);

//        return new ResponseEntity<>("Printing completed transactions", HttpStatus.OK);
    }




}