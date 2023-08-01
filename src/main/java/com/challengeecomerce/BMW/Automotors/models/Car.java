package com.challengeecomerce.BMW.Automotors.models;

import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;
import com.challengeecomerce.BMW.Automotors.models.enums.CarType;
import com.challengeecomerce.BMW.Automotors.models.enums.ModType;
import javax.persistence.*;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String details;
    private String model;
    private Year date;
    private CarColor carColor;
    private Double price;
    private String description;
    @ElementCollection
    private List<Integer> payments;
    private Boolean packM;
    private CarType carType;
    private Integer stock;
    @ElementCollection
    @CollectionTable(name = "car_images", joinColumns = @JoinColumn(name = "car_id"))
    @Column(name = "image")
    private List<String> images;
    @ElementCollection
    @CollectionTable(name = "carMod", joinColumns = @JoinColumn(name = "mod_id"))
    @Column(name = "mod")
    private List<ModType> modType;
    @ManyToOne(fetch = FetchType.EAGER)
    private MeetingReservation meetingReservation;
    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private Set<PlanDuesCar> planDuesCarSet = new HashSet<>();
    public Car() {
    }

    public Car(String details, String model, Year date, CarColor carColor, Double price, String description, List<Integer> payments, Boolean packM, CarType carType, Integer stock, List<String> images, List<ModType>  modType) {

        this.details = details;
        this.model = model;
        this.date = date;
        this.carColor = carColor;
        this.price = price;
        this.description = description;
        this.payments = payments;
        this.packM = packM;
        this.carType = carType;
        this.stock = stock;
        this.images = images;
        this.modType = modType;
    }
    public Long getId() {
        return id;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public Year getDate() {
        return date;
    }

    public void setDate(Year date) {
        this.date = date;
    }
    public CarColor getCarColor() {
        return carColor;
    }
    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Integer> getPayments() {
        return payments;
    }
    public void setPayments(List<Integer> payments) {
        this.payments = payments;
    }
    public Boolean getPackM() {
        return packM;
    }
    public void setPackM(Boolean packM) {
        this.packM = packM;
    }
    public CarType getCarType() {
        return carType;
    }
    public void setCarType(CarType carType) {
        this.carType = carType;
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
    public List<ModType> getModType() {
        return modType;
    }
    public void setModType(List<ModType> modType) {
        this.modType = modType;
    }
    public MeetingReservation getMeetingReservation() {return meetingReservation;}
    public void setMeetingReservation(MeetingReservation meetingReservation) {this.meetingReservation = meetingReservation;}
    public Set<PlanDuesCar> getPlanDuesCarSet() {return planDuesCarSet;}
    public void addPlanDuesCar(PlanDuesCar planDuesCar) {
        planDuesCar.setCar(this);
        this.planDuesCarSet.add(planDuesCar);
    }
}
