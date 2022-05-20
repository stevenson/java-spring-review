package com.stevenson.demo.dao;

import com.stevenson.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int create(UUID id, Person person){
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> retrieveAll() {
        return DB;
    }

    @Override
    public Optional<Person> retrieveById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int update(UUID id, Person update) {
        return retrieveById(id)
                .map(person->{
                    int indexOfPerson = DB.indexOf(person);
                    if(indexOfPerson >=0 ){
                        DB.set(indexOfPerson, new Person( id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int deleteById(UUID id) {
        Optional<Person> retrievalResult = retrieveById(id);
        if(retrievalResult.isEmpty()){
            return 0;
        }else{
            DB.remove(retrievalResult.get());
            return 1;
        }
    }

}
