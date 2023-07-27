package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


public class CarModDTO {
        private Long id;
        private Double price;
        private Integer payments;


        public CarModDTO() {
        }

        public CarModDTO(CarMod carMod) {
            this.id = carMod.getId();
            this.price = carMod.getPrice();
            this.payments = carMod.getPayment();

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
