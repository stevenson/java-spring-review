package com.stevenson.demo.service;

import com.stevenson.demo.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person create(Person person);

    Person update(Long id, Person person);

    Optional<Person> get(Long id);

    List<Person> getAll();

    boolean delete(Long id);

}
