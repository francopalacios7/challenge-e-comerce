package com.challengeecomerce.BMW.Automotors.dtos;

import java.time.LocalDateTime;

public class MeetingReservationDTO {
    private LocalDateTime meetingReservation;
    private String email;
    public MeetingReservationDTO() {
    }
    public LocalDateTime getMeetingReservation() {return meetingReservation;}
    public String getEmail() {
        return email;
    }
}
