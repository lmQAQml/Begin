package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.jws.soap.SOAPBinding;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
        // 无加密,使用原始字符串
//        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password(getPasswordEncoder().encode("admin"))
                        .authorities("looking", "searching", "excel")
                        .build(),
                User.withUsername("visitor")
                        .password(getPasswordEncoder().encode("visitor"))
                        .authorities("looking")
                        .build(),
                User.withUsername("excel")
                        .password(getPasswordEncoder().encode("excel"))
                        .authorities("excel")
                        .build()
        );
    }
}
