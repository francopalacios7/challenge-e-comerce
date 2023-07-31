package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.DuesPlan;
import com.challengeecomerce.BMW.Automotors.models.PlanDuesCar;
import java.time.LocalDate;

public class PlanDuesCarDTO {
    private Long id;
    private LocalDate date;
    private Double amount;
    private Car car;
    private DuesPlan duesPlan;
    public PlanDuesCarDTO(PlanDuesCar planDuesCar) {
        this.id = planDuesCar.getId();
        this.date = planDuesCar.getDate();
        this.amount = planDuesCar.getAmount();
        this.car = planDuesCar.getCar();
        this.duesPlan = planDuesCar.getDuesPlan();
    }
    public Long getId() {return id;}
    public LocalDate getDate() {return date;}
    public Double getAmount() {return amount;}
    public Car getCar() {return car;}
    public DuesPlan getDuesPlan() {return duesPlan;}
}
