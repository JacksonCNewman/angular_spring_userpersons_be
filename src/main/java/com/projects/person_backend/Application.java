package com.projects.person_backend;

import com.projects.person_backend.entity.Person;
import com.projects.person_backend.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(PersonRepository personRepository) {
        return args -> {
            Stream.of( "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                Person person = new Person(name, name.toLowerCase() + "@domain.com");
                personRepository.save(person);
            });
            personRepository.findAll().forEach(user -> {
                System.out.println(user.getName());
            });
        };
    }

}
