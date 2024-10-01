package com.demo.project.workers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@EnableMongoRepositories
@SpringBootApplication
public class WorkersApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkersApplication.class, args);
    }

}
