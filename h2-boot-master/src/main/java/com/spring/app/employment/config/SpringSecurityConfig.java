package com.spring.app.employment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		
		authenticationManagerBuilder.inMemoryAuthentication()
		.withUser("demouser").password("{noop}password").roles("USER")
		.and()
		.withUser("adminuser").password("{noop}adminadmin").roles("USER", "ADMIN");
	}
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.httpBasic().and()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/calculateIncomeTax").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/states").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/state/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/state/create").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/state/update").hasRole("ADMIN")
		.and()
		.csrf().disable()
		.formLogin().disable();
	}
	
}
