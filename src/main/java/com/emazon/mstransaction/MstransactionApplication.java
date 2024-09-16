package com.emazon.mstransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients()
public class MstransactionApplication {
	public static void main(String[] args) {
		SpringApplication.run(MstransactionApplication.class, args);
	}
}
