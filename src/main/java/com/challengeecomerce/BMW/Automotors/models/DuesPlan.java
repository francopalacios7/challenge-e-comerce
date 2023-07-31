package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;

@Entity
public class DuesPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String planDescription;
    private String dues;
    private Double interest;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plan_id")
    private Purchase purchase;
    public DuesPlan(String planDescription, String dues, Double interest) {
        this.planDescription = planDescription;
        this.dues = dues;
        this.interest = interest;
    }
    public Long getId() {return id;}
    public String getPlanDescription() {return planDescription;}
    public void setPlanDescription(String planDescription) {this.planDescription = planDescription;}
    public String getDues() {return dues;}
    public void setDues(String dues) {this.dues = dues;}
    public Double getInterest() {return interest;}
    public void setInterest(Double interest) {this.interest = interest;}
}
