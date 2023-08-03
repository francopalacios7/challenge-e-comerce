package com.challengeecomerce.BMW.Automotors.dtos;

import java.time.LocalDateTime;
import java.time.Year;

public class MeetingReservationDTO {
    private LocalDateTime meetingReservation;
    private String email;
    private String message;
    private Year date;
    private String model;
    public MeetingReservationDTO() {
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getMeetingReservation() {return meetingReservation;}
    public String getEmail() {
        return email;
    }

    public Year getDate() {
        return date;
    }

    public String getModel() {
        return model;
    }
}
