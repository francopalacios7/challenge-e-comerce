package com.challengeecomerce.BMW.Automotors.services;

import com.challengeecomerce.BMW.Automotors.models.DuesPlan;

public interface DuesPlanService {
    void save(DuesPlan duesPlan);
    DuesPlan findById(Long id);
    void delete(DuesPlan duesPlan);
}
