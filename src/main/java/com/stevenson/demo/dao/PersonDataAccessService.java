package com.stevenson.demo.dao;

import com.stevenson.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PersonDataAccessService implements PersonDao{
    @Override
    public int create(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> retrieveAll() {
        return null;
    }

    @Override
    public Optional<Person> retrieveById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int update(UUID id, Person person) {
        return 0;
    }

    @Override
    public int deleteById(UUID id) {
        return 0;
    }
}
