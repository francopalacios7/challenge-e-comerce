package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.DuesPlan;

public class DuesPlanDTO {
    private Long id;
    private String planDescription;
    private String dues;
    private Double interest;
    private boolean isActive;
    public DuesPlanDTO(){}
    public DuesPlanDTO(DuesPlan duesPlan) {
        this.id = duesPlan.getId();
        this.planDescription = duesPlan.getPlanDescription();
        this.dues = duesPlan.getDues();
        this.interest = duesPlan.getInterest();
        this.isActive = duesPlan.isActive();
    }
    public Long getId() {return id;}
    public String getPlanDescription() {return planDescription;}
    public String getDues() {return dues;}
    public Double getInterest() {return interest;}
    public boolean isActive() {return isActive;}
}
