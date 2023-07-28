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

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, CarRepository carRepository) {
		return (args -> {


			Client pepe = new Client("Pepe", "Honguito", "pepe@gmail.com", passwordEncoder.encode("melba456"), "direccion", "23456");
			clientRepository.save(pepe);

			Car car1 = new Car("BMW X5", LocalDate.of(2022, 5, 15), CarColor.BLUE, 75000.0, "The BMW X5 is a luxury mid-size SUV known for its premium features, powerful performance, and spacious interior. As part of BMW's X-series lineup, the X5 offers a blend of comfort, technology, and driving dynamics. It typically seats five to seven passengers, depending on the configuration, and comes with a range of engine options, including turbocharged gasoline and diesel engines. The X5 is designed to provide a smooth and comfortable ride on the road while offering all-wheel-drive capability for light off-road adventures. It boasts advanced technology and safety features, making it an attractive choice for families and individuals seeking a high-end SUV experience.",
					Arrays.asList(12, 24, 36), true,
					50,
					Arrays.asList("https://i.postimg.cc/6QGnyp2J/1-2.webp", "https://i.postimg.cc/L5vZrq7f/3-2.webp",
							"https://i.postimg.cc/wjMhYV9B/2-2.webp", "https://i.postimg.cc/52r84CtS/5-2.webp",
							"https://i.postimg.cc/15CqBqD1/4-2.webp"),
					Arrays.asList(ModType.ALLOY_WHEELS, ModType.NAVIGATION_SYSTEM));

			Car car2 = new Car("BMW M340i", LocalDate.of(2023, 2, 10), CarColor.BLUE, 50000.0,"The BMW M340i is a high-performance variant of the popular 3 Series sedan. As part of BMW's M Performance lineup, the M340i focuses on delivering sportier driving dynamics and increased power. Under the hood, it is equipped with a powerful turbocharged inline-six engine that produces exhilarating acceleration and enhanced handling capabilities. The M340i features performance-oriented upgrades to its suspension, brakes, and exhaust system, providing a more engaging driving experience compared to the standard 3 Series models. It also comes with distinctive M design elements, both on the exterior and interior, showcasing its sportier character.",
					Arrays.asList(24, 36, 48), false,
					8,
					Arrays.asList("https://i.postimg.cc/tTQPPGW1/1-3.webp", "https://i.postimg.cc/5yfC75Pb/2-3.webp",
							"https://i.postimg.cc/138Nj3Kn/3-3.webp", "https://i.postimg.cc/L8GZKFyy/4-3.webp",
							"https://i.postimg.cc/yYvFG545/5-3.webp"),
					Arrays.asList(ModType.SUNROOF, ModType.PERFORMANCE_EXHAUST));

			Car car3 = new Car("BMW 140i", LocalDate.of(2023, 1, 5), CarColor.WHITE, 95000.0,"The BMW 140i, specifically the 1 Series (F20/F21) 140i, is a compact luxury hatchback (3-door or 5-door) or coupe manufactured by BMW. It is part of the 1 Series lineup and is recognized for its agile handling and peppy performance. The 140i is powered by a potent turbocharged inline-six engine, delivering strong acceleration and responsive driving dynamics. With its rear-wheel-drive layout and sporty suspension setup, the 140i offers an engaging driving experience. As a compact luxury car, it provides a well-appointed interior with modern features and technologies, making it an appealing option for driving enthusiasts who prioritize performance in a smaller package.",
					Arrays.asList(12, 24, 36, 60), true,
					3,
					Arrays.asList("https://i.postimg.cc/WpmmGz9s/1.webp", "https://i.postimg.cc/Fs9yDvq3/2.webp",
							"https://i.postimg.cc/TwVbJNJt/3.webp", "https://i.postimg.cc/hPPmVrz0/4.webp",
							"https://i.postimg.cc/D0cqnpWS/5.webp"),
					Arrays.asList(ModType.SPOILER, ModType.TINTED_WINDOWS));


			carRepository.saveAll(Arrays.asList(car1, car2, car3));
		});
	}
}
