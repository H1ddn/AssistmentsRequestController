package org.example;

import jakarta.annotation.PostConstruct;
import org.example.model.RequestType;
import org.example.store.RequestTypeStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = "org.example")
public class Main {
    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    @Autowired
    public void initRequestTypes(final RequestTypeStore requestTypeStore) {
        requestTypeStore.add_request_type(new RequestType(null, "PROBLEM_REQUEST"));
        requestTypeStore.add_request_type(new RequestType(null, "QUESTION_REQUEST"));
    }
}
