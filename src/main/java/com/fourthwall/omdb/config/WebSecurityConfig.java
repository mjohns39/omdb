package com.fourthwall.omdb.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/movies/**/*").permitAll()
                .antMatchers("/users/**/*").permitAll()
                .antMatchers("/criticRatings/**/*").permitAll()
                .antMatchers("/userRatings/**/*").permitAll()
                .antMatchers(HttpMethod.GET, "/movieShowtimes/**/*").permitAll()
                .anyRequest()
                .authenticated()
        ;
    }
}

