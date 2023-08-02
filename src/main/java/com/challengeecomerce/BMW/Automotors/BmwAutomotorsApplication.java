package com.challengeecomerce.BMW.Automotors;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.DuesPlan;
import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;
import com.challengeecomerce.BMW.Automotors.models.enums.CarType;
import com.challengeecomerce.BMW.Automotors.models.enums.ModType;
import com.challengeecomerce.BMW.Automotors.repositories.*;
import com.challengeecomerce.BMW.Automotors.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class BmwAutomotorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmwAutomotorsApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	PurchaseService purchaseService;

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, CarRepository carRepository, ModRepository modRepository, ModTypeRepository modTypeRepository, DuesPlanRepository duesPlanRepository) {
		return (args -> {

			Client Pepe = new Client("Pepe", "Honguito","micagpili@gmail.com", passwordEncoder.encode("melba456"),"direccion","23456");
			clientRepository.save(Pepe);
			Client Lucas = new Client("Pepe", "Honguito","correalucasmatias98@gmail.com", passwordEncoder.encode("melba456"),"direccion","23456");
			clientRepository.save(Lucas);
			//Client admin = new Client());


			Car car1 = new Car(Arrays.asList("Weight: 2,310kg",
					"Fuel Capacity: 80 liters",
					"Acceleration: 0 to 100 km/h in 6.5 seconds)",
					"Final Speed: 250 km/h"),"BMW X5", Year.of(2022), CarColor.BLUE, 75000.0, "The BMW X5 is a luxury mid-size SUV known for its premium features, powerful performance, and spacious interior. As part of BMW's X-series lineup, the X5 offers a blend of comfort, technology, and driving dynamics. ",
					Arrays.asList(12, 24, 36), true, CarType.SUV,
					50,
					Arrays.asList("https://i.postimg.cc/KckChXJw/BMW-X5-Prior-Design-1-1130x636-removebg-preview.webp", "https://i.postimg.cc/Rh4tdxFh/358554307-693967395873744-7241302121445480103-n.webp",
							"https://i.postimg.cc/DZVLWX3q/358511910-594935189380768-4470808167427975233-n.webp", "https://i.postimg.cc/52r84CtS/5-2.webp",
							"https://hips.hearstapps.com/hmg-prod/images/bmw-x5-m-competition-2020-1600-35-1570006295.jpg"),
					Arrays.asList(ModType.ALLOY_WHEELS, ModType.NAVIGATION_SYSTEM));

			Car car2 = new Car(Arrays.asList("Weight: 1,680kg",
					"Fuel Capacity: 60 liters",
					"Acceleration: 0 to 100 km/h in 5.1 seconds",
					"Final Speed: 250 km/h"),"BMW M340i", Year.of(2023), CarColor.BLUE, 50000.0,"The BMW M340i is a high-performance variant of the popular 3 Series sedan. As part of BMW's M Performance lineup, the M340i focuses on delivering sportier driving dynamics and increased power.",
					Arrays.asList(24, 36, 48), false, CarType.CAR,
					8,
					Arrays.asList("https://i.postimg.cc/sfNdMkj9/340.png", "https://i.postimg.cc/tTQPPGW1/1-3.webp",
							"https://i.postimg.cc/138Nj3Kn/3-3.webp", "https://i.postimg.cc/L8GZKFyy/4-3.webp",
							"https://i.postimg.cc/yYvFG545/5-3.webp"),
					Arrays.asList(ModType.SUNROOF, ModType.PERFORMANCE_EXHAUST));

			Car car3 = new Car(Arrays.asList("Weight: 1,510kg",
					"Fuel Capacity: 52 liters",
					"Acceleration: 0 to 100 km/h in 5.1 seconds",
					"Final Speed: 250 km/h"),"BMW 140i", Year.of(2023), CarColor.WHITE, 95000.0,"The BMW 140i, specifically the 1 Series (F20/F21) 140i, is a compact luxury hatchback (3-door or 5-door) or coupe manufactured by BMW. It is part of the 1 Series lineup and is recognized for its agile handling and peppy performance.",
					Arrays.asList(12, 24, 36, 60), true, CarType.CAR,
					3,
					Arrays.asList("https://i.postimg.cc/c4FKt4Kk/BMW-M1-PNG-Photo.png", "https://i.postimg.cc/Fs9yDvq3/2.webp",
							"https://i.postimg.cc/q7QTcgFq/9ciq4t.webp", "https://i.postimg.cc/hPPmVrz0/4.webp",
							"https://i.postimg.cc/D0cqnpWS/5.webp"),
					Arrays.asList(ModType.NONE));

			Car car4 = new Car(Arrays.asList("Weight: 2,370kg",
					"Fuel Capacity: 85 liters",
					"Acceleration: 0 to 100 km/h in 6.5 seconds",
					"Final Speed: 250 km/h"),"BMW X6", Year.of(2022), CarColor.BLACK, 120000.0,
					"The BMW M5 is a high-performance luxury sedan known for its powerful engine and precise handling.",
					Arrays.asList(12, 24, 36, 48), true, CarType.SUV,
					4,
					Arrays.asList("https://i.postimg.cc/Pf950t30/x6-0.webp",
							"https://i.postimg.cc/nLFFqMr9/x6-1.webp",
							"https://i.postimg.cc/YSdpRkLn/x6-2.webp",
							"https://i.postimg.cc/y8Bgr1Ws/x6-3.webp",
							"https://i.postimg.cc/FFdLYC25/x6-4.webp"),
					Arrays.asList(ModType.PERFORMANCE_EXHAUST, ModType.NAVIGATION_SYSTEM));


			Car car5 = new Car(Arrays.asList("Weight: 2,000kg",
					"Fuel Capacity: 68 liters",
					"Acceleration: 0 to 100 km/h in 4.3 seconds",
					"Final Speed: 250 km/h"), "BMW M5", Year.of(2021), CarColor.WHITE, 135000.0,
					"The BMW i8 is a plug-in hybrid sports car known for its futuristic design and impressive performance.",
					Arrays.asList(12, 24, 36, 60), true, CarType.CAR,
					2,
					Arrays.asList("https://i.postimg.cc/CK7K2kX4/m5-0.webp",
							"https://i.postimg.cc/zB3qPMnJ/m5-1.webp",
							"https://i.postimg.cc/44DhVbgK/m5-2.webp",
							"https://i.postimg.cc/C1KKpdVp/m5-3.webp",
							"https://i.postimg.cc/Jzc7yjrW/m5-4.webp"),
					Arrays.asList(ModType.SUNROOF, ModType.ALLOY_WHEELS));

			Car moto1 = new Car (Arrays.asList("Weight: 208kg",
					"Fuel Capacity: 16.5 liters",
					"Acceleration: 0 to 100 km/h in around 3 seconds",
					"Final Speed: Exceeds 300 km/h"), "BMW S1000RR", Year.of(2023), CarColor.BLACK, 18000.0,
					"The BMW S1000RR is a high-performance sportbike known for its powerful engine and advanced technology.",
					Arrays.asList(6, 12, 18, 24), true, CarType.MOTORCYCLE, 15,
					Arrays.asList("https://i.postimg.cc/dtbSXr7h/1000rr-0-2.png",
							"https://i.postimg.cc/1tN3324v/1000rr-1.webp",
							"https://i.postimg.cc/rsXF0jrM/1000rr-2.webp",
							"https://i.postimg.cc/FKCYR0pH/1000rr-3.webp"),
					Arrays.asList(ModType.NONE));

// Crear moto2 (BMW R1250GS)
			Car moto2 = new Car(Arrays.asList("Weight: 268 kg",
					"Fuel Capacity: 20 liters",
					"Acceleration: 0 to 100 km/h in around 4 seconds",
					"Final Speed: Over 200 km/h"), "BMW R1250GS", Year.of(2020), CarColor.BLACK, 23000.0,
					"The BMW R1250GS is a premium adventure motorcycle designed for long-distance touring and off-road adventures.",
					Arrays.asList(6, 12, 24, 36), true, CarType.MOTORCYCLE,23,
					Arrays.asList("https://i.postimg.cc/ZKdbkPq3/r1250-0-removebg-preview.png",
							"https://i.postimg.cc/8PvzSqxc/r1250-1.webp",
							"https://i.postimg.cc/vBjGRzz5/r1250-2.webp",
							"https://i.postimg.cc/DwKyyxKg/r1250-3.webp"),
					Arrays.asList(ModType.NONE));

// Crear moto3 (BMW G310GS)
			Car moto3 = new Car(Arrays.asList("Weight: 169.5kg",
					"Fuel Capacity: 11 liters",
					"Acceleration: 0 to 100 km/h in around 4 seconds",
					"Final Speed: Up to 150 km/h"), "BMW G310GS", Year.of(2024), CarColor.BLACK, 9000.0,
					"The BMW G310GS is an entry-level adventure motorcycle perfect for urban commuting and light off-road use.",
					Arrays.asList(6, 12, 18, 24), true, CarType.MOTORCYCLE, 17,
					Arrays.asList("https://i.postimg.cc/VkPYzSSh/g310-0-removebg-preview.png",
							"https://i.postimg.cc/85qsdDq8/g310-1.webp",
							"https://i.postimg.cc/4xCnHJpp/g310-2.webp",
							"https://i.postimg.cc/8cJPs35y/g310-3.webp"),
					Arrays.asList(ModType.NONE));


			carRepository.saveAll(Arrays.asList(car1, car2, car3, car4,car5, moto1,moto2,moto3));

			com.challengeecomerce.BMW.Automotors.models.ModType navigationSystem1 = new com.challengeecomerce.BMW.Automotors.models.ModType("Navigation System");
			com.challengeecomerce.BMW.Automotors.models.ModType sunroof1 = new com.challengeecomerce.BMW.Automotors.models.ModType("Sunroof");
			com.challengeecomerce.BMW.Automotors.models.ModType tintedWindows1 = new com.challengeecomerce.BMW.Automotors.models.ModType("Tinted Windows");
			com.challengeecomerce.BMW.Automotors.models.ModType spoilerBlack1 = new com.challengeecomerce.BMW.Automotors.models.ModType("Spoiler Black");
			com.challengeecomerce.BMW.Automotors.models.ModType spoilerBlue1 = new com.challengeecomerce.BMW.Automotors.models.ModType("Spoiler Blue");
			com.challengeecomerce.BMW.Automotors.models.ModType spoilerWhite1 = new com.challengeecomerce.BMW.Automotors.models.ModType("Spoiler White");
			com.challengeecomerce.BMW.Automotors.models.ModType alloyWheels5 = new com.challengeecomerce.BMW.Automotors.models.ModType("Alloy Wheels");
			com.challengeecomerce.BMW.Automotors.models.ModType performanceExhaustBlack1 = new com.challengeecomerce.BMW.Automotors.models.ModType("Performance Exhaust Black");

			modTypeRepository.saveAll(Arrays.asList( navigationSystem1, sunroof1, tintedWindows1, spoilerBlue1, spoilerBlack1, spoilerWhite1, alloyWheels5, performanceExhaustBlack1));

			Mod navigationSystem = new Mod("Navigation System", "Installs a GPS navigation system", 300.0, CarColor.BLACK, 5, Arrays.asList("https://i.postimg.cc/W3gsYRZR/navigation-system.webp"), navigationSystem1);
			Mod sunroof = new Mod("Sunroof", "Adds a sunroof for an open-air experience", 150.0, CarColor.BLACK, 12, Arrays.asList("https://i.postimg.cc/FK29xF7g/sun-roof.webp"), sunroof1);
			Mod tintedWindows = new Mod("Tinted Windows", "Adds tint to the car windows for privacy", 50.0, CarColor.BLACK, 15, Arrays.asList("https://i.postimg.cc/x18nDNm3/tinted-windows.webp"), tintedWindows1);

			Mod spoilerBlack = new Mod("Spoiler", "Adds a sporty spoiler to the car", 100.0, CarColor.BLACK, 10, Arrays.asList("https://i.postimg.cc/T2jRr6Gg/black-spoiler.webp"), spoilerBlack1);
			Mod spoilerBlue = new Mod("Spoiler", "Adds a sporty spoiler to the car", 100.0, CarColor.BLUE, 10, Arrays.asList("https://i.postimg.cc/Bv8SDPQn/blue-spoiler.webp"), spoilerBlue1);
			Mod spoilerWhite = new Mod("Spoiler", "Adds a sporty spoiler to the car", 100.0, CarColor.WHITE, 10, Arrays.asList("https://i.postimg.cc/MKdqFmnG/white-spoiler.webp"), spoilerWhite1);

			Mod alloyWheels = new Mod("Alloy Wheels", "Upgrades the wheels to stylish alloy wheels", 800.0, CarColor.BLACK, 12, Arrays.asList("https://i.postimg.cc/cC74Cq17/alloy-wheels1.webp"), alloyWheels5);
			Mod alloyWheels1 = new Mod("Alloy Wheels", "Upgrades the wheels to stylish alloy wheels", 1600.0, CarColor.BLACK, 8, Arrays.asList("https://i.postimg.cc/1RDzJF0g/alloy-wheels2.webp"),alloyWheels5);
			Mod alloyWheel2 = new Mod("Alloy Wheels", "Upgrades the wheels to stylish alloy wheels", 2000.0, CarColor.BLACK, 16, Arrays.asList("https://i.postimg.cc/WzVTQ9md/alloy-wheels3.webp"),alloyWheels5);
			Mod alloyWheel3 = new Mod("Alloy Wheels", "Upgrades the wheels to stylish alloy wheels", 4000.0, CarColor.BLACK, 32, Arrays.asList("https://i.postimg.cc/kgYMBvCH/alloy-wheels4.webp"),alloyWheels5);
			Mod alloyWheel4 = new Mod("Alloy Wheels", "Upgrades the wheels to stylish alloy wheels", 3300.0, CarColor.BLACK, 26, Arrays.asList("https://i.postimg.cc/SxxNStB8/alloy-wheels5.webp"),alloyWheels5);

			Mod performanceExhaustBlack = new Mod("Performance Exhaust", "Enhances the car's exhaust system for better performance", 250.0, CarColor.BLACK, 10,Arrays.asList("https://i.postimg.cc/1XKsPpMJ/performance-exhaust.webp"), performanceExhaustBlack1);

			modRepository.saveAll(Arrays.asList(navigationSystem,sunroof,tintedWindows,alloyWheel3,alloyWheel4,alloyWheel2,alloyWheels1,alloyWheels,spoilerWhite,spoilerBlue,spoilerBlack,performanceExhaustBlack));

			DuesPlan duesPlan1 = new DuesPlan("Plan A", "36", 0.3, true );
			DuesPlan duesPlan2 = new DuesPlan("Plan A", "48", 0.4, true );
			DuesPlan duesPlan3 = new DuesPlan("Plan A", "60", 0.5, true );

			duesPlanRepository.saveAll(Arrays.asList(duesPlan1,duesPlan2,duesPlan3));

		});
	}
}