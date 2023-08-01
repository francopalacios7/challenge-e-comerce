package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PlanDuesCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double amount;
    @ManyToOne(fetch = FetchType.EAGER)
    private Car car;
    @ManyToOne(fetch = FetchType.EAGER)
    private DuesPlan duesPlan;
    public PlanDuesCar(LocalDate date, Double amount) {
        this.date = date;
        this.amount = amount;
    }
    public Long getId() {return id;}
    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date = date;}
    public Double getAmount() {return amount;}
    public void setAmount(Double amount) {this.amount = amount;}
    public Car getCar() {return car;}
    public void setCar(Car car) {this.car = car;}
    public DuesPlan getDuesPlan() {return duesPlan;}
    public void setDuesPlan(DuesPlan duesPlan) {this.duesPlan = duesPlan;}

}
