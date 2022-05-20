package com.stevenson.demo.service;

import com.stevenson.demo.model.Person;
import com.stevenson.demo.repo.PersonRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Service
@Slf4j
public class DefaultPersonService
        implements PersonService {

    @Autowired
    private PersonRepo personRepo;


    @Override
    public Person create(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person update(Long id, Person person) {
        Person toSave = personRepo.findById(id).map(p -> {
            p.setName(person.getName());
            return p;
        }).orElseThrow(RuntimeException::new);
        return personRepo.save(toSave);
    }

    @Override
    public Optional<Person> get(Long id) {
        return personRepo.findById(id);
    }

    @Override
    public List<Person> getAll() {
        return stream(personRepo.findAll().spliterator(), false)
                .collect(toList());
    }

    @Override
    public boolean delete(Long id) {
        try {
            personRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            log.warn("failed to delete {}", id);
            return false;
        }
    }
}
