package com.projects.person_backend.controller;

import com.projects.person_backend.entity.Person;
import com.projects.person_backend.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/users")
    public List<Person> getUsers() {
        return (List<Person>) personRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody Person user){
        personRepository.save(user);
    }

}
