package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MeetingReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime meetingReservation;
    private String email;
    private String message;
    private Year date; //año del auto
    private String model;  //modelo del auto
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "meetingReservation", fetch = FetchType.EAGER)
    private Set<Car> carSet = new HashSet<>();
    public MeetingReservation() {
    }
    public MeetingReservation(LocalDateTime meetingReservation, String email, String message, Year date, String model) {
        this.meetingReservation = meetingReservation;
        this.email = email;
        this.message = message;
        this.date = date;
        this.model = model;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public LocalDateTime getMeetingReservation() {
        return meetingReservation;
    }
    public String getEmail() {
        return email;
    }
    public void setMeetingReservation(LocalDateTime meetingReservation) {this.meetingReservation = meetingReservation;}
    public void setEmail(String email) {this.email = email;}
    public Long getId() {return id;}
    public Client getClient() {return client;}
    public void setClient(Client client) {this.client = client;}
    public Set<Car> getCarSet() {return carSet;}
    public void addCar(Car car) {
        car.setMeetingReservation(this);
        this.carSet.add(car);
    }
}
