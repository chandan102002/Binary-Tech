package com.example.bankProjetc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter
{

	@SuppressWarnings("deprecation")
	@Bean
	@Override
	protected UserDetailsService userDetailsService()
	{
		List<UserDetails> users= new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("Binary").password("1234567890").roles("admin").build());
		users.add(User.withDefaultPasswordEncoder().username("chandan").password("2002").roles("user").build());
		return new InMemoryUserDetailsManager(users);
	}
	

}
