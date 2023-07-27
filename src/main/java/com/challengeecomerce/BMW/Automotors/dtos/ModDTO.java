package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.CarModDos;
import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.models.ModPurchase;
import com.challengeecomerce.BMW.Automotors.models.Purchase;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ModDTO {

    private Long id;
    private String name;

    private Double price;

    private CarColor carColor;

    //private Set<ModPurchase> modPurchaseSet = new HashSet<>();

    private Set<CarModDosDTO> carModDosDTO;

    public ModDTO() {
    }

    public ModDTO(Mod mod) {
        this.id = mod.getId();
        this.name = mod.getName();
        this.price = mod.getPrice();
        this.carColor = mod.getCarColor();
        this.carModDosDTO = mod.getCarModDosSet()
                .stream()
                .map(carModDos -> new CarModDosDTO(carModDos))
                .collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public Set<CarModDosDTO> getCarModDosDTO() {
        return carModDosDTO;
    }
}
