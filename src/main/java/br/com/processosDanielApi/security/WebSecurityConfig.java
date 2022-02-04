package br.com.processosDanielApi.security;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*
		 * SW: 02/02/22
		 * 
		 * Descomentar caso ativar a seguranca via token JWT (baerer) 
		 * 
		 */
		
		//httpSecurity.csrf().disable().authorizeRequests()
			//.antMatchers("/home").permitAll()
			//.antMatchers(HttpMethod.POST, "/login").permitAll()
			//.anyRequest().authenticated()
			//.and()
			
			// filtra requisições de login
			//.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
	              //  UsernamePasswordAuthenticationFilter.class)
			
			// filtra outras requisições para verificar a presença do JWT no header
			//.addFilterBefore(new JWTAuthenticationFilter(),
	          //      UsernamePasswordAuthenticationFilter.class);
		
		httpSecurity.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * SW: 02/02/22
		 * 
		 * Descomentar para ativar o /login, para obter o token JWT de acesso ao resources (servicos) 
		 * 
		 */

		
		// cria uma conta default
		//auth.inMemoryAuthentication()
			//.withUser("admin")
			//.password("password")
			//.roles("ADMIN");
	}

}
