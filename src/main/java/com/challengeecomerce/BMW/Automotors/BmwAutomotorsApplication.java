package com.challengeecomerce.BMW.Automotors;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;
import com.challengeecomerce.BMW.Automotors.models.enums.ModType;
import com.challengeecomerce.BMW.Automotors.repositories.CarRepository;
import com.challengeecomerce.BMW.Automotors.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class BmwAutomotorsApplication {
	public static void main(String[] args) {
		SpringApplication.run(BmwAutomotorsApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Bean // cada vez q se crea la app
	public CommandLineRunner initData(ClientRepository clientRepository, CarRepository carRepository){ // declaro la var
		return (args -> {
			Client Pepe = new Client("Pepe", "Honguito","micagpili@gmail.com", passwordEncoder.encode("melba456"),"direccion","23456");
			clientRepository.save(Pepe);
			Client Lucas = new Client("Pepe", "Honguito","correalucasmatias98@gmail.com", passwordEncoder.encode("melba456"),"direccion","23456");
			clientRepository.save(Lucas);
			//Client admin = new Client());


//			autos hardcodeados para pruebas



			Car car1 = new Car("BMW X5", LocalDate.of(2022, 5, 15), CarColor.BLUE, 75000.0,
					Arrays.asList(12, 24, 36), true,
					50,
					Arrays.asList("https://i.postimg.cc/Z5TJsKh8/1.jpg", "https://i.postimg.cc/Jh0Mm60t/2.jpg", "https://i.postimg.cc/9fkVfdwb/3.jpg","https://i.postimg.cc/rwQMBX8v/4.jpg","https://i.postimg.cc/vB6yx4Ws/5.jpg" ),
					Arrays.asList(ModType.ALLOY_WHEELS, ModType.NAVIGATION_SYSTEM));

			Car car2 = new Car("BMW M340i", LocalDate.of(2023, 2, 10), CarColor.BLUE, 50000.0,
					Arrays.asList(24, 36, 48), false,
					8,
					Arrays.asList("https://i.postimg.cc/dV0zT7Yx/1.jpg", "https://i.postimg.cc/q7PYYjCP/2.jpg", "https://i.postimg.cc/mD7qGCYt/3.jpg", "https://i.postimg.cc/hvgY4vsM/4.jpg",  "https://i.postimg.cc/qqL5NrZr/5.jpg"),
					Arrays.asList(ModType.SUNROOF, ModType.PERFORMANCE_EXHAUST));

			Car car3 = new Car("BMW 140i", LocalDate.of(2023, 1, 5), CarColor.WHITE, 95000.0,
					Arrays.asList(12, 24, 36, 60), true,
					3,
					Arrays.asList( "https://i.postimg.cc/nrPLbyYF/1.jpg", "https://i.postimg.cc/rynsr46B/2.jpg", "https://i.postimg.cc/vHCmPdZX/3.jpg", "https://i.postimg.cc/MpRpNrcw/4.jpg", "https://i.postimg.cc/6583LQty/5.jpg"),
					Arrays.asList(ModType.SPOILER, ModType.TINTED_WINDOWS));

				carRepository.saveAll(Arrays.asList(car1, car2,car3));

		});
	}}

