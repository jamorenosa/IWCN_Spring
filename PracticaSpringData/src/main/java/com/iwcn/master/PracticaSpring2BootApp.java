package com.iwcn.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories()
public class PracticaSpring2BootApp {

    public static void main(String[] args) {
        SpringApplication.run(PracticaSpring2BootApp.class, args);
    }

}
