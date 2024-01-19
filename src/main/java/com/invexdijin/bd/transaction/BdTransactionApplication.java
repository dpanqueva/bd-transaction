package com.invexdijin.bd.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BdTransactionApplication implements CommandLineRunner {

	@Value("${spring.datasource.url}")
	private String jdbcUrl;

	@Value("${spring.datasource.username}")
	private String username;

	public static void main(String[] args) {
		SpringApplication.run(BdTransactionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("connection url: {}", jdbcUrl);
		log.info("username: {}", username);
	}
}
