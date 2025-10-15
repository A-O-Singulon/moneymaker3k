package com.scorenerds.ScoreNerds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScoreNerdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoreNerdsApplication.class, args);
	}

}
