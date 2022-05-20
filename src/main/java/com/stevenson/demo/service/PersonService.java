package com.stevenson.demo.service;

import com.stevenson.demo.dao.PersonDao;
import com.stevenson.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao){
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.create(person);
    }

    public List<Person> getAllPeople(){
        return personDao.retrieveAll();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.retrieveById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deleteById(id);
    }

    public int updatePerson(UUID id, Person person){
        return personDao.update(id, person);
    }
}
