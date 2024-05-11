package com.projects.person_backend.repository;

import com.projects.person_backend.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
