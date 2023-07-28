package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.CarDTO;
import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.services.CarService;
import com.challengeecomerce.BMW.Automotors.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    ClientService clientService;
    @Autowired
    CarService carService;
    @GetMapping("/car")
    public Set<CarDTO> getAll() {
        return carService.getAllCarsDTO();
    }

    @PostMapping("/admin/cars")
    public ResponseEntity<Object> addCar(@RequestBody CarDTO carDTO, Authentication authentication){

// Client client = clientService.findByEmail(authentication.getName());


//        if(!client.getEmail().contains("admin")){
//            return new ResponseEntity<>("Only the admin can add cars.", HttpStatus.FORBIDDEN);
//        }
        if(carDTO.getModel().isBlank()){
            return new ResponseEntity<>("Model is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if(carDTO.getDate().toString().isBlank()){
            return new ResponseEntity<>("Date is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if(carDTO.getCarColor().toString().isBlank()){
            return new ResponseEntity<>("Color is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if(carDTO.getPrice() < 70000){
            return new ResponseEntity<>("Price invalid, please try again.", HttpStatus.FORBIDDEN);
        }
        if(carDTO.getPayments().isEmpty()){
            return new ResponseEntity<>("Payments invalid, please try again.", HttpStatus.FORBIDDEN);
        }
        if(carDTO.getStock() <= 0 ){
            return new ResponseEntity<>("Stock invalid, please try again.", HttpStatus.FORBIDDEN);
        }
        if(carDTO.getPackM().toString().isBlank()){
            return new ResponseEntity<>("PackM must be selected, please try again.", HttpStatus.FORBIDDEN);
        }
        Car car1 = new Car(carDTO.getModel(), carDTO.getDate(), carDTO.getCarColor(), carDTO.getPrice(), carDTO.getDescription(), carDTO.getPayments(), carDTO.getPackM(), carDTO.getStock(), carDTO.getImages(), carDTO.getModType());
        carService.saveCar(car1);
        return new ResponseEntity<>("Car added successfully.", HttpStatus.CREATED);
    }

}