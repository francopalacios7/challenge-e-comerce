package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ClientPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate creationDate;
    private Double totalAmount;
    private Integer amount;
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    @OneToMany(mappedBy = "clientPurchase", fetch= FetchType.EAGER)
    private Set<Purchase> purchaseSet = new HashSet<>();

    public ClientPurchase() {
    }

    public ClientPurchase(Double totalAmount, Integer articlesAmount) {
        this.totalAmount = totalAmount;
        this.amount = articlesAmount;
        this.creationDate = LocalDate.now();
    }
    public Long getId() {
        return id;
    }
    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Set<Purchase> getPurchaseSet() {
        return purchaseSet;
    }
    public LocalDate getCreationDate() {return creationDate;}
    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}
    public void setPurchaseSet(Set<Purchase> purchaseSet) {
        this.purchaseSet = purchaseSet;
    }
    public Integer getArticlesAmount() {return amount;}
    public void setArticlesAmount(Integer articlesAmount) {this.amount = articlesAmount;}
}
