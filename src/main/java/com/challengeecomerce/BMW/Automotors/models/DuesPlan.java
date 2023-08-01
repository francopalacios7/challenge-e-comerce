package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DuesPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String planDescription;
    private String dues;
    private Double interest;
    private boolean isActive;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plan_id")
    private Purchase purchase;
    @OneToMany(mappedBy = "duesPlan", fetch = FetchType.EAGER)
    private Set<PlanDuesCar> planDuesCarSet = new HashSet<>();
    public DuesPlan(String planDescription, String dues, Double interest, boolean isActive) {
        this.planDescription = planDescription;
        this.dues = dues;
        this.interest = interest;
        this.isActive = isActive;
    }
    public Long getId() {return id;}
    public String getPlanDescription() {return planDescription;}
    public void setPlanDescription(String planDescription) {this.planDescription = planDescription;}
    public String getDues() {return dues;}
    public void setDues(String dues) {this.dues = dues;}
    public Double getInterest() {return interest;}
    public void setInterest(Double interest) {this.interest = interest;}
    public Purchase getPurchase() {return purchase;}
    public void setPurchase(Purchase purchase) {this.purchase = purchase;}
    public Set<PlanDuesCar> getPlanDuesCarSet() {return planDuesCarSet;}
    public boolean isActive() {return isActive;}
    public void setActive(boolean active) {isActive = active;}
    public void setPlanDuesCarSet(Set<PlanDuesCar> planDuesCarSet) {this.planDuesCarSet = planDuesCarSet;}
    public void addPlanDuesCar(PlanDuesCar planDuesCar) {
        planDuesCar.setDuesPlan(this);
        this.planDuesCarSet.add(planDuesCar);
    }



}