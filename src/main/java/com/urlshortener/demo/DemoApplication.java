package com.urlshortener.demo;

import com.urlshortener.demo.url.Url;
import com.urlshortener.demo.url.UrlRepository;
import com.urlshortener.demo.url.UrlService;
import com.urlshortener.demo.user.User;
import com.urlshortener.demo.user.UserRepository;
import com.urlshortener.demo.util.UrlDuplicate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


        }



