package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.CarDTO;
import com.challengeecomerce.BMW.Automotors.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    CarService carService;
    @GetMapping("/car")
    public Set<CarDTO> getAll() {
    return carService.getAllCarsDTO();

}
}
