package com.challengeecomerce.BMW.Automotors.dtos;

import java.time.LocalDateTime;

public class TurnReservationDTO {

    private LocalDateTime turReservation;
    private String email;

    public TurnReservationDTO() {
    }

    public LocalDateTime getTurReservation() {
        return turReservation;
    }

    public String getEmail() {
        return email;
    }
}
