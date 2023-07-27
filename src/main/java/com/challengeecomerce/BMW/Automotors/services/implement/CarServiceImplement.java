package com.challengeecomerce.BMW.Automotors.services.implement;

import com.challengeecomerce.BMW.Automotors.dtos.CarDTO;
import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.repositories.CarRepository;
import com.challengeecomerce.BMW.Automotors.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class CarServiceImplement implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Set<CarDTO> getAllCarsDTO() {
        return carRepository.findAll().stream().map(CarDTO::new).collect(toSet());
    }

    @Override
    public CarDTO getOneCar(Long id) {
        return carRepository.findById(id).map(CarDTO::new).orElse(null);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }


}
