package com.challengeecomerce.BMW.Automotors.services.implement;

import com.challengeecomerce.BMW.Automotors.models.DuesPlan;
import com.challengeecomerce.BMW.Automotors.repositories.DuesPlanRepository;
import com.challengeecomerce.BMW.Automotors.services.DuesPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuesPlanImplement implements DuesPlanService {
    @Autowired
    private DuesPlanRepository duesPlanRepository;
    @Override
    public void save(DuesPlan duesPlan) {duesPlanRepository.save(duesPlan);}

    @Override
    public DuesPlan findById(Long id) {return duesPlanRepository.findById(id).orElse(null);}

    @Override
    public void delete(DuesPlan duesPlan) {duesPlanRepository.delete(duesPlan);}
}
