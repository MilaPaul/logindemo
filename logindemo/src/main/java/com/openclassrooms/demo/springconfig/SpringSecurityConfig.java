package com.openclassrooms.demo.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws    Exception {
	        auth.inMemoryAuthentication()
	            .withUser("springuser").password(passwordEncoder().encode("spring123")).roles("USER")
	          	.and()
	         	.withUser("springadmin").password(passwordEncoder().encode("admin123"))
	         	.roles("ADMIN", "USER");
	                
	    }
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
        .authorizeRequests()
        .antMatchers("/admin*").hasRole("ADMIN")
        .antMatchers("/user*").hasRole("USER")
        .anyRequest().authenticated()
        .and()
        .formLogin();
 
		}
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
	