package com.challengeecomerce.BMW.Automotors.services;

import com.challengeecomerce.BMW.Automotors.dtos.DuesPlanDTO;
import com.challengeecomerce.BMW.Automotors.models.DuesPlan;

import java.util.List;

public interface DuesPlanService {
    void save(DuesPlan duesPlan);
    DuesPlan findById(Long id);
    void delete(DuesPlan duesPlan);
    List<DuesPlanDTO> findAll();
}
