package com.skilldistillery.tabletennis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TableTennisApplication extends SpringBootServletInitializer {
	
	  @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(TableTennisApplication.class);
	  }

	public static void main(String[] args) {
		SpringApplication.run(TableTennisApplication.class, args);
	}

}
