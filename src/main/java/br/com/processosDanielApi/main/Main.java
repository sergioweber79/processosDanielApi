package br.com.processosDanielApi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableAutoConfiguration
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan({"br.com.processosDanielApi.resource","br.com.processosDanielApi.service","br.com.processosDanielApi.security"})
@EntityScan("br.com.processosDanielApi.dominio")
@EnableJpaRepositories("br.com.processosDanielApi.repository")
public class Main extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Main.class);
	}

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);

	}

}
