package com.challengeecomerce.BMW.Automotors.services.implement;

import com.challengeecomerce.BMW.Automotors.models.MeetingReservation;
import com.challengeecomerce.BMW.Automotors.repositories.MeetingReservationRepository;
import com.challengeecomerce.BMW.Automotors.services.MeetingReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingReservationServiceImplement implements MeetingReservationService {

    @Autowired
    private MeetingReservationRepository meetingReservationRepository;


    @Override
    public void save(MeetingReservation meetingReservation) {
        meetingReservationRepository.save(meetingReservation);
    }
}
