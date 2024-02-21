package ru.otus.otusxgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OtusXGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtusXGeneratorApplication.class, args);
	}
}
