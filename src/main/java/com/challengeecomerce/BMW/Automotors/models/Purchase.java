package com.challengeecomerce.BMW.Automotors.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double totalAmount;
    @ElementCollection
    private List<Integer> payments;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "purchase",fetch = FetchType.EAGER)
    private Set<CarPurchase> carPurchaseSet = new HashSet<>();
    @OneToMany(mappedBy = "purchase",fetch = FetchType.EAGER)
    private Set<ModPurchase> modPurchaseSet = new HashSet<>();
    @OneToMany(mappedBy = "purchase",fetch = FetchType.EAGER)
    private Set<CarModPurchase> carModPurchaseSet = new HashSet<>();

    public Purchase() {
    }
    public Purchase(LocalDate date, double totalAmount, List<Integer> payments) {
        this.date = date;
        this.totalAmount = totalAmount;
        this.payments = payments;
    }
    public Long getId() {
        return id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {this.date = date;}
    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public List<Integer> getPayments() {
        return payments;
    }
    public void setPayments(List<Integer> payments) {
        this.payments = payments;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public Set<CarPurchase> getCarPurchaseSet() {
        return carPurchaseSet;
    }

    public void setCarPurchaseSet(Set<CarPurchase> carPurchaseSet) {
        this.carPurchaseSet = carPurchaseSet;
    }

    public Set<ModPurchase> getModPurchaseSet() {
        return modPurchaseSet;
    }

    public void setModPurchaseSet(Set<ModPurchase> modPurchaseSet) {
        this.modPurchaseSet = modPurchaseSet;
    }

    public Set<CarModPurchase> getCarModPurchaseSet() {
        return carModPurchaseSet;
    }

    public void setCarModPurchaseSet(Set<CarModPurchase> carModPurchaseSet) {
        this.carModPurchaseSet = carModPurchaseSet;
    }


}
