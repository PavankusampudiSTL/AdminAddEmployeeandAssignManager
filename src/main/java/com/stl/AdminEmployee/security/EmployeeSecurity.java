package com.stl.AdminEmployee.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class EmployeeSecurity extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().
        antMatchers("/adminemployee/addemployee","/adminemployee/get","/adminemployee/get/{email}","/adminemployee/delete/{email}").permitAll().antMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest()
        .authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
    }    
}
