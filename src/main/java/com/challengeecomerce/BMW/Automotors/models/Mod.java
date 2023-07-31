package com.challengeecomerce.BMW.Automotors.models;

import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Mod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, description;

    private Double price;

    private CarColor carColor;

    private Integer stock;

    @ElementCollection
    @CollectionTable(name = "mod_images", joinColumns = @JoinColumn(name = "mod_id"))
    @Column(name = "images")
    private List<String> images;

    @OneToMany(mappedBy = "mod", fetch = FetchType.EAGER)
    private Set<ModPurchase> modPurchaseSet = new HashSet<>();
    @OneToMany(mappedBy = "mod", fetch = FetchType.EAGER)
    private Set<CarModDos> carModDosSet = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modType")
    private com.challengeecomerce.BMW.Automotors.models.ModType modType;


    public Mod() {
    }

    public Mod(String name, String description, Double price, CarColor carColor, Integer stock, List <String> images, ModType modType) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.carColor = carColor;
        this.stock = stock;
        this.images = images;
        this.modType = modType;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public ModType getModType() {
        return modType;
    }

    public void setModType(ModType modType) {
        this.modType = modType;
    }
}
