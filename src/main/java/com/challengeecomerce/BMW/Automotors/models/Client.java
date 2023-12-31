package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String phone;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<ClientPurchase> clientPurchaseSet = new HashSet<>();
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<MeetingReservation> meetingReservationSet = new HashSet<>();
    public Client() {
    }
    public Client( String firstName, String lastName, String email, String password, String address, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }
    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void addClientPurchase(ClientPurchase clientPurchase) {
        clientPurchase.setClient(this);
        this.clientPurchaseSet.add(clientPurchase);
    }

    public Set<MeetingReservation> getMeetingReservationSet() {return meetingReservationSet;}
    public void addMeetingReservation(MeetingReservation meetingReservation) {
        meetingReservation.setClient(this);
        this.meetingReservationSet.add(meetingReservation);
    }
    public Set<ClientPurchase> getClientPurchaseSet() {return clientPurchaseSet;}
    public void setClientPurchaseSet(Set<ClientPurchase> clientPurchaseSet) {this.clientPurchaseSet = clientPurchaseSet;}
    public void setMeetingReservationSet(Set<MeetingReservation> meetingReservationSet) {this.meetingReservationSet = meetingReservationSet;}
}