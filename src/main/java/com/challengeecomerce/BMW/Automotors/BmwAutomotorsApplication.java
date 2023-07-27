package com.challengeecomerce.BMW.Automotors;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;
import com.challengeecomerce.BMW.Automotors.models.enums.ModType;
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
	public CommandLineRunner initData(ClientRepository clientRepository){ // declaro la var
		return (args -> {
			Client Pepe = new Client("Pepe", "Honguito","pepe@gmail.com", passwordEncoder.encode("melba456"),"direccion","23456");
			clientRepository.save(Pepe);
			//Client admin = new Client());


//			autos hardcodeados para pruebas



			Car car1 = new Car("BMW X5", LocalDate.of(2022, 5, 15), CarColor.BLUE, 75000.0,
					Arrays.asList(12, 24, 36), true,
					50,
					Arrays.asList("./static/images/Bmw images/BMW X5/1.jpg", "./static/images/Bmw images/BMW X5/2.jpg", "./static/images/Bmw images/BMW X5/3.jpg","./static/images/Bmw images/BMW X5/4.jpg","./static/images/Bmw images/BMW X5/5.jpg" ),
					Arrays.asList(ModType.ALLOY_WHEELS, ModType.NAVIGATION_SYSTEM));

			Car car2 = new Car("BMW M340i", LocalDate.of(2023, 2, 10), CarColor.BLUE, 50000.0,
					Arrays.asList(24, 36, 48), false,
					8,
					Arrays.asList("./static/images/Bmw images/bmw-m340i/1.jpg", "./static/images/Bmw images/bmw-m340i/2.jpg", "./static/images/Bmw images/bmw-m340i/3.jpg"),
					Arrays.asList(ModType.SUNROOF, ModType.PERFORMANCE_EXHAUST));

			Car car3 = new Car("BMW 140i", LocalDate.of(2023, 1, 5), CarColor.WHITE, 95000.0,
					Arrays.asList(12, 24, 36, 60), true,
					3,
					Arrays.asList("./static/images/Bmw images/BMW 140i/1.jpg"),
					Arrays.asList(ModType.SPOILER, ModType.TINTED_WINDOWS));

			// Puedes crear más objetos Car según tus necesidades.

			// Imprimir la información de los autos
			System.out.println(car1.toString());
			System.out.println(car2.toString());
			System.out.println(car3.toString());
		});
	}}

