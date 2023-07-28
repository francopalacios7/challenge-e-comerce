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
import com.tinify.Source;
import com.tinify.Tinify;

import java.io.IOException;
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


			Tinify.setKey("CfW4BKk4S0N3Cr2CQ150HzrWj1PlTxS7");

			Client pepe = new Client("Pepe", "Honguito", "pepe@gmail.com", passwordEncoder.encode("melba456"), "direccion", "23456");
			clientRepository.save(pepe);

			Car car1 = new Car("BMW X5", LocalDate.of(2022, 5, 15), CarColor.BLUE, 75000.0,
					Arrays.asList(12, 24, 36), true,
					50,
					Arrays.asList("https://i.postimg.cc/6QGnyp2J/1-2.webp", "https://i.postimg.cc/L5vZrq7f/3-2.webp",
							"https://i.postimg.cc/wjMhYV9B/2-2.webp", "https://i.postimg.cc/52r84CtS/5-2.webp",
							"https://i.postimg.cc/15CqBqD1/4-2.webp"),
					Arrays.asList(ModType.ALLOY_WHEELS, ModType.NAVIGATION_SYSTEM));

			Car car2 = new Car("BMW M340i", LocalDate.of(2023, 2, 10), CarColor.BLUE, 50000.0,
					Arrays.asList(24, 36, 48), false,
					8,
					Arrays.asList("https://i.postimg.cc/tTQPPGW1/1-3.webp", "https://i.postimg.cc/5yfC75Pb/2-3.webp",
							"https://i.postimg.cc/138Nj3Kn/3-3.webp", "https://i.postimg.cc/L8GZKFyy/4-3.webp",
							"https://i.postimg.cc/yYvFG545/5-3.webp"),
					Arrays.asList(ModType.SUNROOF, ModType.PERFORMANCE_EXHAUST));

			Car car3 = new Car("BMW 140i", LocalDate.of(2023, 1, 5), CarColor.WHITE, 95000.0,
					Arrays.asList(12, 24, 36, 60), true,
					3,
					Arrays.asList("https://i.postimg.cc/WpmmGz9s/1.webp", "https://i.postimg.cc/Fs9yDvq3/2.webp",
							"https://i.postimg.cc/TwVbJNJt/3.webp", "https://i.postimg.cc/hPPmVrz0/4.webp",
							"https://i.postimg.cc/D0cqnpWS/5.webp"),
					Arrays.asList(ModType.SPOILER, ModType.TINTED_WINDOWS));

			String imageUrl = "https://i.postimg.cc/Z5TJsKh8/1.jpg";
			String outputFileName = "compressed_image.jpg";

			try {
				Source source = Tinify.fromUrl(imageUrl);
				source.toFile(outputFileName);
				System.out.println("Image compressed and saved to: " + outputFileName);
			} catch (IOException e) {
				System.out.println("Error compressing image from URL: " + imageUrl);
				e.printStackTrace();
			}



			carRepository.saveAll(Arrays.asList(car1, car2, car3));
		});
	}
}
