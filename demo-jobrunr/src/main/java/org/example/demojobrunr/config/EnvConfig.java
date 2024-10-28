package org.example.demojobrunr.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class EnvConfig {

    @Bean
    public String loadEnvVariables() {
        Dotenv dotenv = Dotenv.configure()
                .directory(System.getProperty("user.dir"))
                .filename("environment.env")
                .load();

        // Đặt các biến môi trường
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
        return "Success";
    }
}