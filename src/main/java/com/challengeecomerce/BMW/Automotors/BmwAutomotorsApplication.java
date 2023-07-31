package com.challengeecomerce.BMW.Automotors;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;
import com.challengeecomerce.BMW.Automotors.models.enums.ModType;
import com.challengeecomerce.BMW.Automotors.repositories.CarRepository;
import com.challengeecomerce.BMW.Automotors.repositories.ClientRepository;
import com.challengeecomerce.BMW.Automotors.repositories.ModRepository;
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

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, CarRepository carRepository, ModRepository modRepository ) {
		return (args -> {

			Client pepe = new Client("Pepe", "Honguito", "pepe@gmail.com", passwordEncoder.encode("melba456"), "direccion", "23456");
			clientRepository.save(pepe);

			Car car1 = new Car("BMW X5", LocalDate.of(2022, 5, 15), CarColor.BLUE, 75000.0, "The BMW X5 is a luxury mid-size SUV known for its premium features, powerful performance, and spacious interior. As part of BMW's X-series lineup, the X5 offers a blend of comfort, technology, and driving dynamics. ",
					Arrays.asList(12, 24, 36), true,
					50,
					Arrays.asList("https://i.postimg.cc/KckChXJw/BMW-X5-Prior-Design-1-1130x636-removebg-preview.webp", "",
							"", "https://i.postimg.cc/52r84CtS/5-2.webp",
							"https://hips.hearstapps.com/hmg-prod/images/bmw-x5-m-competition-2020-1600-35-1570006295.jpg"),
					Arrays.asList(ModType.ALLOY_WHEELS, ModType.NAVIGATION_SYSTEM));

			Car car2 = new Car("BMW M340i", LocalDate.of(2023, 2, 10), CarColor.BLUE, 50000.0,"The BMW M340i is a high-performance variant of the popular 3 Series sedan. As part of BMW's M Performance lineup, the M340i focuses on delivering sportier driving dynamics and increased power.",
					Arrays.asList(24, 36, 48), false,
					8,
					Arrays.asList("https://i.postimg.cc/tTQPPGW1/1-3.webp", "https://i.postimg.cc/5yfC75Pb/2-3.webp",
							"https://i.postimg.cc/138Nj3Kn/3-3.webp", "https://i.postimg.cc/L8GZKFyy/4-3.webp",
							"https://i.postimg.cc/yYvFG545/5-3.webp"),
					Arrays.asList(ModType.SUNROOF, ModType.PERFORMANCE_EXHAUST));

			Car car3 = new Car("BMW 140i", LocalDate.of(2023, 1, 5), CarColor.WHITE, 95000.0,"The BMW 140i, specifically the 1 Series (F20/F21) 140i, is a compact luxury hatchback (3-door or 5-door) or coupe manufactured by BMW. It is part of the 1 Series lineup and is recognized for its agile handling and peppy performance.",
					Arrays.asList(12, 24, 36, 60), true,
					3,
					Arrays.asList("https://i.postimg.cc/WpmmGz9s/1.webp", "https://i.postimg.cc/Fs9yDvq3/2.webp",
							"https://i.postimg.cc/TwVbJNJt/3.webp", "https://i.postimg.cc/hPPmVrz0/4.webp",
							"https://i.postimg.cc/D0cqnpWS/5.webp"),
					Arrays.asList(ModType.SPOILER, ModType.TINTED_WINDOWS));




			carRepository.saveAll(Arrays.asList(car1, car2, car3));

			Mod navigationSystem = new Mod("Navigation System", "Installs a GPS navigation system", 300.0, CarColor.BLACK, 5, Arrays.asList("https://i.postimg.cc/W3gsYRZR/navigation-system.webp"));
			Mod sunroof = new Mod("Sunroof", "Adds a sunroof for an open-air experience", 150.0, CarColor.BLACK, 12, Arrays.asList("https://i.postimg.cc/FK29xF7g/sun-roof.webp"));
			Mod tintedWindows = new Mod("Tinted Windows", "Adds tint to the car windows for privacy", 50.0, CarColor.BLACK, 15, Arrays.asList("https://i.postimg.cc/x18nDNm3/tinted-windows.webp"));

			Mod spoilerBlack = new Mod("Spoiler", "Adds a sporty spoiler to the car", 100.0, CarColor.BLACK, 10, Arrays.asList("https://i.postimg.cc/T2jRr6Gg/black-spoiler.webp"));
			Mod spoilerBlue = new Mod("Spoiler", "Adds a sporty spoiler to the car", 100.0, CarColor.BLUE, 10, Arrays.asList("https://i.postimg.cc/Bv8SDPQn/blue-spoiler.webp"));
			Mod spoilerWhite = new Mod("Spoiler", "Adds a sporty spoiler to the car", 100.0, CarColor.WHITE, 10, Arrays.asList("https://i.postimg.cc/MKdqFmnG/white-spoiler.webp"));

			Mod alloyWheels = new Mod("Alloy Wheels", "Upgrades the wheels to stylish alloy wheels", 800.0, CarColor.BLACK, 20, Arrays.asList("https://i.postimg.cc/cC74Cq17/alloy-wheels1.webp"));
			Mod alloyWheels1 = new Mod("Alloy Wheels", "Upgrades the wheels to stylish alloy wheels", 1600.0, CarColor.BLACK, 20, Arrays.asList("https://i.postimg.cc/1RDzJF0g/alloy-wheels2.webp"));
			Mod alloyWheel2 = new Mod("Alloy Wheels", "Upgrades the wheels to stylish alloy wheels", 2000.0, CarColor.BLACK, 20, Arrays.asList("https://i.postimg.cc/WzVTQ9md/alloy-wheels3.webp"));
			Mod alloyWheel3 = new Mod("Alloy Wheels", "Upgrades the wheels to stylish alloy wheels", 4000.0, CarColor.BLACK, 20, Arrays.asList("https://i.postimg.cc/kgYMBvCH/alloy-wheels4.webp"));
			Mod alloyWheel4 = new Mod("Alloy Wheels", "Upgrades the wheels to stylish alloy wheels", 3300.0, CarColor.BLACK, 20, Arrays.asList("https://i.postimg.cc/SxxNStB8/alloy-wheels5.webp"));

			Mod performanceExhaustBlack = new Mod("Performance Exhaust", "Enhances the car's exhaust system for better performance", 250.0, CarColor.BLACK, 10,Arrays.asList("https://i.postimg.cc/1XKsPpMJ/performance-exhaust.webp"));

			modRepository.saveAll(Arrays.asList(navigationSystem,sunroof,tintedWindows,alloyWheel3,alloyWheel4,alloyWheel2,alloyWheels1,alloyWheels,spoilerWhite,spoilerBlue,spoilerBlack,performanceExhaustBlack));

		});
	}
}
