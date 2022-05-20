package com.stevenson.demo.repo;

import com.stevenson.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long> {

}
