package org.example.demojobrunr.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class EnvConfig {

    @Bean
    public Dotenv dotenv() {
        // Lấy đường dẫn của JAR đang chạy
        Path jarDir = Paths.get(System.getProperty("user.dir"));
        return Dotenv.configure()
                .directory(jarDir.toString()) // Thiết lập thư mục là vị trí của JAR
                .filename("environment.env")  // Tên file env
                .load();
    }
}
