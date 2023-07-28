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
    public ResponseEntity<Object> addCar(@RequestBody Car car, Authentication authentication){

       // Client client = clientService.findByEmail(authentication.getName());

//        if(!client.getEmail().contains("admin")){
//            return new ResponseEntity<>("Only tre admin can add cars.", HttpStatus.FORBIDDEN);
//        }

        if(car.getModel().isBlank()){
            return new ResponseEntity<>("Model is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if(car.getDate().toString().isBlank()){
            return new ResponseEntity<>("Date is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if(car.getCarColor().toString().isBlank()){
            return new ResponseEntity<>("Color is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if(car.getPrice() == 0 || car.getPrice() < 70000){
            return new ResponseEntity<>("Price invalid, please try again.", HttpStatus.FORBIDDEN);
        }
        if(car.getPayments().isEmpty()){
            return new ResponseEntity<>("Payments invalid, please try again.", HttpStatus.FORBIDDEN);
        }
        if(car.getStock() == 0 || car.getStock() < 0 ){
            return new ResponseEntity<>("Stock invalid, please try again.", HttpStatus.FORBIDDEN);
        }
        if(car.getPackM().toString().isBlank()){
            return new ResponseEntity<>("PackM must be selected, please try again.", HttpStatus.FORBIDDEN);
        }
        Car car1 = new Car(car.getModel(), car.getDate(), car.getCarColor(), car.getPrice(), car.getPayments(), car.getPackM(), car.getStock(), car.getImages(), car.getModType());
        carService.saveCar(car1);
        return new ResponseEntity<>("Car added successfully.", HttpStatus.CREATED);

    }

}
