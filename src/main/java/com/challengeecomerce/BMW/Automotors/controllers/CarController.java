package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.CarDTO;
import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;
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

    @GetMapping("/car/color")
    public CarColor[] getAllColors() {
        return CarColor.values();
    }

    @PostMapping("/admin/cars")
    public ResponseEntity<Object> addCar(@RequestBody CarDTO carDTO, Authentication authentication) {
// Client client = clientService.findByEmail(authentication.getName());


//        if(!client.getEmail().contains("admin")){
//            return new ResponseEntity<>("Only the admin can add cars.", HttpStatus.FORBIDDEN);
//        }
        if (carDTO.getDetails().isEmpty()) {
            return new ResponseEntity<>("Please add the vehicle details", HttpStatus.FORBIDDEN);
        }
        if (carDTO.getImages().isEmpty()) {
            return new ResponseEntity<>("Please add images to the vehicle", HttpStatus.FORBIDDEN);
        }
        if (carDTO.getModel().isBlank()) {
            return new ResponseEntity<>("Model is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if (carDTO.getDate().toString().isBlank()) {
            return new ResponseEntity<>("Date is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if (carDTO.getCarColor().toString().isBlank()) {
            return new ResponseEntity<>("Color is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if (carDTO.getPrice() < 70000) {
            return new ResponseEntity<>("Price invalid, please try again.", HttpStatus.FORBIDDEN);
        }
        if (carDTO.getPayments().isEmpty()) {
            return new ResponseEntity<>("Payments invalid, please try again.", HttpStatus.FORBIDDEN);
        }
        if (carDTO.getStock() <= 0) {
            return new ResponseEntity<>("Stock invalid, please try again.", HttpStatus.FORBIDDEN);
        }
        if (carDTO.getPackM().toString().isBlank()) {
            return new ResponseEntity<>("PackM must be selected, please try again.", HttpStatus.FORBIDDEN);
        }
        Car car1 = new Car(carDTO.getDetails(), carDTO.getModel(), carDTO.getDate(), carDTO.getCarColor(), carDTO.getPrice(), carDTO.getDescription(), carDTO.getPayments(), carDTO.getPackM(), carDTO.getCarType(), carDTO.getStock(), carDTO.getImages(), carDTO.getModType());
        carService.saveCar(car1);
        return new ResponseEntity<>("Car added successfully.", HttpStatus.CREATED);
    }
    @PatchMapping(path = "/admin/car/update")
    public ResponseEntity<Object> updateCar(Authentication authentication, @RequestBody CarDTO carDTO) {
//        Client client = clientService.findByEmail(authentication.getName());

//        if(!client.getEmail().contains("admin")){
//            return new ResponseEntity<>("Only the admin can Update cars.", HttpStatus.FORBIDDEN);
//        }
        Car carToUpdate = carService.findById(carDTO.getId());
        if(carDTO.getModel().isBlank()){
            return new ResponseEntity<>("Model is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if (carDTO.getDate().toString().isBlank()) {
            return new ResponseEntity<>("Date is blank, please fill the field.", HttpStatus.FORBIDDEN);
        }
        if (carDTO.getCarColor().toString().isBlank()) {
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
        carToUpdate.setModel(carDTO.getModel());
        carToUpdate.setDate(carDTO.getDate());
        carToUpdate.setCarColor(carDTO.getCarColor());
        carToUpdate.setPrice(carDTO.getPrice());
        carToUpdate.setPayments(carDTO.getPayments());
        carToUpdate.setStock(carDTO.getStock());
        carToUpdate.setPackM(carDTO.getPackM());
        carService.saveCar(carToUpdate);
        return new ResponseEntity<>("Car Updated successfully.", HttpStatus.OK);
    }

    @PatchMapping("/admin/car/delete/{id}")
    public ResponseEntity<Object> deleteCard(@PathVariable Long id, Authentication authentication) {
        //        Client client = clientService.findByEmail(authentication.getName());

//        if(!client.getEmail().contains("admin")){
//            return new ResponseEntity<>("Only the admin can Update cars.", HttpStatus.FORBIDDEN);
//        }

        Car car = carService.findById(id);
        if (car == null) {
            return new ResponseEntity<>("Car invalid, please try again.", HttpStatus.FORBIDDEN);
        }
        if (car.getActive()) {
            car.setActive(false);
            carService.saveCar(car);
        }
        return new ResponseEntity<>("Car deleted succesfully.", HttpStatus.ACCEPTED);
    }
}


