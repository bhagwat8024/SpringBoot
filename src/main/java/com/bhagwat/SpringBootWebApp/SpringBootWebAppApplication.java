package com.bhagwat.SpringBootWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class SpringBootWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebAppApplication.class, args);
	}
	@Bean
	public ViewResolver configureViewResolver() 
	{
	  InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
	  viewResolve.setSuffix(".jsp");
	  return viewResolve;
	}
}
