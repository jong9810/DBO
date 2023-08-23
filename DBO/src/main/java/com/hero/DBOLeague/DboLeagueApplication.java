package com.hero.DBOLeague;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controller","dto","dao","service"})
@MapperScan(basePackages = {"dao"})
public class DboLeagueApplication {

	public static void main(String[] args) {
		SpringApplication.run(DboLeagueApplication.class, args);
	}

}
