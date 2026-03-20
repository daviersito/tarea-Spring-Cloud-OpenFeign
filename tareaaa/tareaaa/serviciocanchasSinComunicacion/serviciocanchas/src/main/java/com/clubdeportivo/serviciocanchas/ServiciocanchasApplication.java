package com.clubdeportivo.serviciocanchas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiciocanchasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiciocanchasApplication.class, args);
	}

}
