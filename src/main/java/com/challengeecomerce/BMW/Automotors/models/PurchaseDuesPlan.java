package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseDuesPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate purchaseCreation;
    private Integer purchaseDuesPlanQuantity;

}
