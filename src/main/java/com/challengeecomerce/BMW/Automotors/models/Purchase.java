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
    private double totalAmount;
    @ElementCollection
    private List<Integer> payments;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "purchase",fetch = FetchType.EAGER)
    private Set<Car> carSet = new HashSet<>();
    @OneToMany(mappedBy = "purchase",fetch = FetchType.EAGER)
    private Set<Mod> modSet = new HashSet<>();
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Integer> getPayments() {
        return payments;
    }

    public void setPayments(List<Integer> payments) {
        this.payments = payments;
    }
    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    @JsonIgnore
    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }
    @JsonIgnore
    public Set<Mod> getModsSet() {
        return modSet;
    }

    public void setModsSet(Set<Mod> modSet) {
        this.modSet = modSet;
    }
}
