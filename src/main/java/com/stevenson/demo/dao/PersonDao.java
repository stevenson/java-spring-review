package com.stevenson.demo.dao;

import com.stevenson.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int create(UUID id, Person person);

    default int create(Person person){
        UUID id = UUID.randomUUID();
        return create(id, person);
    }

    List<Person> retrieveAll();


    Optional<Person> retrieveById(UUID id);
    int update(UUID id, Person person);
    int deleteById(UUID id);

}
