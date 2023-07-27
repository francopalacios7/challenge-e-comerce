package com.challengeecomerce.BMW.Automotors.services;

import com.challengeecomerce.BMW.Automotors.dtos.CarDTO;
import com.challengeecomerce.BMW.Automotors.models.Car;

import java.util.Set;

public interface CarService {

    void saveCar(Car car);

    Set<CarDTO> getAllCarsDTO();

    CarDTO getOneCar(Long id);

    Car findById(Long id);

}
