package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.DuesPlanDTO;
import com.challengeecomerce.BMW.Automotors.dtos.ModPurchasePDFExporterDTO;
import com.challengeecomerce.BMW.Automotors.models.*;
import com.challengeecomerce.BMW.Automotors.services.*;
import com.challengeecomerce.BMW.Automotors.utils.ModPDFExporter;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;
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

    @Autowired
    private ModService modService;

    @Autowired
    private ModPurchaseService modPurchaseService;

    @Autowired
    private ClientPurchaseService clientPurchaseService;

    @Autowired
    private PurchaseService purchaseService;
  
   @GetMapping("/duesPlan")
    public List<DuesPlanDTO> getAllDuesDTO(){
        return duesPlanService.findAll();
    }

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
    public ResponseEntity<Object> deleteDuesPlan(Authentication authentication, DuesPlanDTO duesPlanDTO) {
        //Client client = clientService.findByEmail(authentication.getName());
        DuesPlan duesPlan = duesPlanService.findById(duesPlanDTO.getId());
        duesPlan.setActive(false);
        duesPlanService.save(duesPlan);
        return new ResponseEntity<>("Dues plan deleted with success", HttpStatus.ACCEPTED);
    }

    @PutMapping("/admin/duesPlan")
    public ResponseEntity<Object> updateDuesPlan(Authentication authentication, @RequestBody DuesPlanDTO duesPlanDTO) {
        //Client client = clientService.findByEmail(authentication.getName());
        DuesPlan duesPlan = duesPlanService.findById(duesPlanDTO.getId());
        if (duesPlanDTO.getDues().isBlank()) {
            return new ResponseEntity<>("Dues is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if (duesPlanDTO.getPlanDescription().isBlank()) {
            return new ResponseEntity<>("Description is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if (duesPlanDTO.getInterest().isNaN()) {
            return new ResponseEntity<>("Interest is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        duesPlan.setDues(duesPlan.getDues());
        duesPlan.setPlanDescription(duesPlan.getPlanDescription());
        duesPlan.setInterest(duesPlan.getInterest());
        duesPlan.setActive(duesPlan.isActive());
        duesPlanService.save(duesPlan);
        return new ResponseEntity<>("Dues plan updated successfully.", HttpStatus.OK);
    }


    @PostMapping(path = "/modPurchase/PDF")
    public void transactionsPDF(Authentication authentication, HttpServletResponse response, @RequestBody List<ModPurchasePDFExporterDTO> modPurchasePDFExporterDTO) throws DocumentException, IOException {

        Client client = clientService.findByEmail(authentication.getName());




        List<Mod> mods = new ArrayList<>();
        modPurchasePDFExporterDTO.forEach(a -> mods.add(modService.findById(a.getModId())));


        double finalPrice = 0;
        for (ModPurchasePDFExporterDTO modPurchaseDTO : modPurchasePDFExporterDTO) {
            Mod mod = modService.findById(modPurchaseDTO.getModId());
            if (mod != null) {
                finalPrice += mod.getPrice() * modPurchaseDTO.getAmount();
            }
        }


        Set<ClientPurchase> clientPurchase = new HashSet<>();
        ClientPurchase clientPurchase1 = new ClientPurchase(finalPrice);
        clientPurchase.add(clientPurchase1);



                response.setContentType("application/pdf");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//        String currentDateTime = dateFormat.format(new Date());
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=transactions"+currentDateTime + ".pdf";

//        List<Mod> listTransactions = this.modService.getTransactionsByDate (date.getLocalDateTimeStart(),date.getLocalDateTimeEnd());
        ModPDFExporter exporter = new ModPDFExporter(mods, client,finalPrice, clientPurchase1.getTotalAmount());
        exporter.export(response);

//        return new ResponseEntity<>("Printing completed transactions", HttpStatus.OK);
    }

}
