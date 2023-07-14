package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = {"org.example.Enum", "org.example", "org.example.Objects", "org.example.Stores"})
public class Main {
    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
