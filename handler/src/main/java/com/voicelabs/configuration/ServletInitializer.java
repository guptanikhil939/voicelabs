package com.voicelabs.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.amazon.speech.speechlet.services.DirectiveService;
import com.amazon.speech.speechlet.services.DirectiveServiceClient;

@Configuration
@SpringBootApplication
@ServletComponentScan(basePackages = {"com.voicelabs.configuration"})
@ComponentScan(basePackages= {"com.voicelabs.handler","com.voicelabs.configuration"})
@EnableScheduling
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ServletInitializer.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(ServletInitializer.class, args);
	}
}
