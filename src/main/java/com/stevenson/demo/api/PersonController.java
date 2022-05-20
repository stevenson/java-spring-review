package com.stevenson.demo.api;

import com.stevenson.demo.model.Person;
import com.stevenson.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public Person addPerson(@Valid @NonNull @RequestBody Person person){
        return personService.create(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAll();
    }

    @GetMapping(path ="/{id}")
    public Person getPersonById(@PathVariable("id") Long id){
        return personService.get(id)
                .orElse(null);
    }

    @PutMapping(path="{id}")
    public void updatePerson(@PathVariable("id") Long id, @Valid @NonNull @RequestBody Person personToUpdate){
        personService.update(id, personToUpdate);
    }

    @DeleteMapping(path ="/{id}")
    public void deletePersonById(@PathVariable("id") Long id){
        personService.delete(id);
    }
}
