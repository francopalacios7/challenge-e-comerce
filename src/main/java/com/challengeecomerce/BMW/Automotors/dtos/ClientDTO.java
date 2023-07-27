package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.Purchase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String phone;
    private Set<PurchaseDTO> purchaseSet;
    public ClientDTO() {
    }
    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.address = client.getAddress();
        this.phone = client.getPhone();
        this.purchaseSet = client.getPurchaseSet()
               .stream()
               .map(PurchaseDTO::new)
              .collect(Collectors.toSet());
        this.password = client.getPassword();
    }
    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public Set<PurchaseDTO> getPurchaseSet() {
        return purchaseSet;
    }
    public String getPassword(){return password;}
    public String getAddress() {return address;}
    public String getPhone() {return phone;}
}
