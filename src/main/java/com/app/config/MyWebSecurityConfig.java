package com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/test/looking/*").hasAnyAuthority("looking")
                .antMatchers("/test/searching/*").hasAnyAuthority("searching")
                .antMatchers("/excel/*").hasAnyAuthority("excel")
                .anyRequest().authenticated()
                .and()
                .formLogin()
        ;
    }
}
