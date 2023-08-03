package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.ClientPurchase;
import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.models.Purchase;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.Set;

public class ModPurchasePDFExporterDTO {

        private Long modId;
        private Double amount;


    public ModPurchasePDFExporterDTO() {
    }


    public Long getModId() {
        return modId;
    }

    public Double getAmount() {
        return amount;
    }

}

