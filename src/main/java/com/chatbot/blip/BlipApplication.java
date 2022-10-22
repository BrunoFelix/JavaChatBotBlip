package com.chatbot.blip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BlipApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlipApplication.class, args);
	}

}
