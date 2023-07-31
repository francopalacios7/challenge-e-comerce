package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.CarModDos;
import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.models.ModPurchase;
import com.challengeecomerce.BMW.Automotors.models.Purchase;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;
import com.challengeecomerce.BMW.Automotors.models.enums.ModType;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ModDTO {

    private Long id;
    private String name, description;

    private Double price;

    private CarColor carColor;
    private Integer stock;

    private List<String> images;

    private ModType modtype;

    public ModDTO() {
    }

    public ModDTO(Mod mod) {
        this.id = mod.getId();
        this.name = mod.getName();
        this.description = mod.getDescription();
        this.price = mod.getPrice();
        this.carColor = mod.getCarColor();
        this.stock = mod.getStock();
        this.images = mod.getImages();
        this.modtype = mod.getModType();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public Integer getStock() {
        return stock;
    }

    public List<String> getImages() {
        return images;
    }

    public ModType getModtype() {
        return modtype;
    }
}
