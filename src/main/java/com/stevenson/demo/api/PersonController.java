package com.stevenson.demo.api;

import com.stevenson.demo.model.Person;
import java.util.List;

public interface PersonController {

    PersonDto addPerson(CreatePersonRequest person);

    List<PersonDto> getAllPeople();
//
////    PersonDto getPersonById(Long id);
////
////    void updatePerson(Long id, PersonDto personToUpdate);
////
////    void deletePersonById(Long id);

}
