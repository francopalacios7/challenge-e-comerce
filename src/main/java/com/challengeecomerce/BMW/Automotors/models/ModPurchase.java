package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ModPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;

    private LocalDateTime modPurchaseDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mod_id")
    private Mod mod;
    public ModPurchase() {
    }
    public ModPurchase(Integer quantity, LocalDateTime modPurchaseDate, Purchase purchase, Mod mod) {
        this.quantity = quantity;
        this.modPurchaseDate = LocalDateTime.now();
        this.purchase = purchase;
        this.mod = mod;
    }
    public Long getId() {
        return id;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Purchase getPurchase() {
        return purchase;
    }
    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
    public Mod getMod() {
        return mod;
    }
    public void setMod(Mod mod) {
        this.mod = mod;
    }
}
