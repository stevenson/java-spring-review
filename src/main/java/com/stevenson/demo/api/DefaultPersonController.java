package com.stevenson.demo.api;

import com.stevenson.demo.model.Person;
import com.stevenson.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("api/v1/person")
@RestController
public class DefaultPersonController implements PersonController{
    private final PersonService personService;

    @Autowired
    public DefaultPersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public PersonDto addPerson(@Valid @NonNull @RequestBody CreatePersonRequest request){
        Person newPerson =  personService.create(
                Person.builder().name(request.getName()).build());
        return convertToDto(newPerson);
    }

    @GetMapping
    public List<PersonDto> getAllPeople(){
        return personService.getAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private PersonDto convertToDto(Person person){
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName()).build();
    }

    
//    @GetMapping(path ="/{id}")
//    public Person getPersonById(@PathVariable("id") Long id){
//        return personService.get(id)
//                .orElse(null);
//    }
//
//    @PutMapping(path="{id}")
//    public void updatePerson(@PathVariable("id") Long id, @Valid @NonNull @RequestBody Person personToUpdate){
//        personService.update(id, personToUpdate);
//    }
//
//    @DeleteMapping(path ="/{id}")
//    public void deletePersonById(@PathVariable("id") Long id){
//        personService.delete(id);
//    }

}
