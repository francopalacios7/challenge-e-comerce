package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.DuesPlanDTO;
import com.challengeecomerce.BMW.Automotors.dtos.DuesPlanPDFExporterDTO;
import com.challengeecomerce.BMW.Automotors.dtos.ModPurchasePDFExporterDTO;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.DuesPlan;
import com.challengeecomerce.BMW.Automotors.models.MeetingReservation;
import com.challengeecomerce.BMW.Automotors.repositories.DuesPlanRepository;
import com.challengeecomerce.BMW.Automotors.services.ClientService;
import com.challengeecomerce.BMW.Automotors.services.DuesPlanService;
import com.challengeecomerce.BMW.Automotors.services.PurchaseService;
import com.challengeecomerce.BMW.Automotors.utils.DuesPlanPDFExporter;
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
    public List<DuesPlanDTO> getAllDuesDTO() {
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


    //    @PostMapping(path = "/purchase/duesPlanPDF")
//    public void transactionsPDF(HttpServletResponse response, @RequestBody DuesPlanPDFExporterDTO duesPlan) throws DocumentException, IOException {
////        Client client = clientService.findByEmail(authentication.getName());
////        if (client == null){
////            return new ResponseEntity<>("The Client does not exist", HttpStatus.FORBIDDEN);
////        }
//
//        DuesPlan duesPlanToPrint = duesPlanService.findById(duesPlan.getId());
//
//// Crea una lista de DuesPlan y agrega el objeto duesPlanToPrint a la lista
//        List<DuesPlan> listDuesPlan = new ArrayList<>();
//        listDuesPlan.add(duesPlanToPrint);
//
////        Client clientOwnTransactions = accountToPrint.getClient();
//        response.setContentType("application/pdf");
//
//        List<Transaction> listTransactions = this.transactionService.getTransactionsByDate(date.getLocalDateTimeStart(), date.getLocalDateTimeEnd(), accountToPrint);
//        DuesPlanPDFExporter exporter = new DuesPlanPDFExporter(listDuesPlan);
//        return new ResponseEntity<>("Printing completed transactions", HttpStatus.OK);
//    }
//
//}
    @PostMapping(path = "/modPurchase/PDF")
    public void transactionsPDF(Authentication authentication, HttpServletResponse response, @RequestBody List<ModPurchasePDFExporterDTO> modPurchasePDFExporterDTO) throws DocumentException, IOException {

        Client client = clientService.findByEmail(authentication.getName());




        List<Mod> mods = new ArrayList<>();
        modPurchasePDFExporterDTO.forEach(a -> mods.add(modService.findById(a.getModId())));


        List<Double> individualPrices = new ArrayList<>();
        for (ModPurchasePDFExporterDTO modPurchaseDTO : modPurchasePDFExporterDTO) {
            Mod mod = modService.findById(modPurchaseDTO.getModId());
            if (mod != null) {
                double individualPrice = mod.getPrice() * modPurchaseDTO.getAmount();
                individualPrices.add(individualPrice);
            }
        }
        int productNumber = 1;
        for (double price : individualPrices) {
            System.out.println("Producto " + productNumber + ": " + price);
            productNumber++;
        }


        List<Double> individualAmounts = new ArrayList<>();
        for(ModPurchasePDFExporterDTO modPurchaseDTO : modPurchasePDFExporterDTO){
            Mod mod = modService.findById(modPurchaseDTO.getModId());
            if (mod != null) {
                Double individualAmount = Double.valueOf(modPurchaseDTO.getAmount());
                individualAmounts.add(individualAmount);
            }
        }

        int finalAmount = 0;
        for (ModPurchasePDFExporterDTO modPurchaseDTO : modPurchasePDFExporterDTO){
            Mod mod = modService.findById(modPurchaseDTO.getModId());
            if (mod != null){
                finalAmount += modPurchaseDTO.getAmount() * mod.getPrice();
                System.out.println(" finalAmount " + finalAmount );
            }
        }

//        Set<ClientPurchase> clientPurchase = new HashSet<>();
//        ClientPurchase clientPurchase1 = new ClientPurchase(individualPrices,finalAmount);
//        clientPurchase.add(clientPurchase1);



        response.setContentType("application/pdf");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//        String currentDateTime = dateFormat.format(new Date());
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=transactions"+currentDateTime + ".pdf";

//        List<Mod> listTransactions = this.modService.getTransactionsByDate (date.getLocalDateTimeStart(),date.getLocalDateTimeEnd());
        ModPDFExporter exporter = new ModPDFExporter(mods, client,individualPrices, individualAmounts, finalAmount);
        exporter.export(response);

//        return new ResponseEntity<>("Printing completed transactions", HttpStatus.OK);
    }

}

