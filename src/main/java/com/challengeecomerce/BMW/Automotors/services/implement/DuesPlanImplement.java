package com.challengeecomerce.BMW.Automotors.services.implement;

import com.challengeecomerce.BMW.Automotors.models.DuesPlan;
import com.challengeecomerce.BMW.Automotors.repositories.DuesPlanRepository;
import com.challengeecomerce.BMW.Automotors.services.DuesPlanService;
import org.springframework.beans.factory.annotation.Autowired;

public class DuesPlanImplement implements DuesPlanService {
    @Autowired
    DuesPlanRepository duesPlanRepository;
    @Override
    public void save(DuesPlan duesPlan) {duesPlanRepository.save(duesPlan);}
}
