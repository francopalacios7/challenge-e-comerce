package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.CarModDos;

public class CarModDosDTO {
    private Long id;

    private Double price;

    private Integer payments;


    public CarModDosDTO() {
    }

    public CarModDosDTO(CarModDos cardModDos) {
        this.id = cardModDos.getId();
        this.price = cardModDos.getPrice();
        this.payments = cardModDos.getPayments();

    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getPayments() {
        return payments;
    }

}
