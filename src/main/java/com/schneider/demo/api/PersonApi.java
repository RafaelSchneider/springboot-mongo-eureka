package com.schneider.demo.api;

import com.schneider.demo.dto.Person;
import com.schneider.demo.mapper.PersonMapper;
import com.schneider.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/schneider/person")
public class PersonApi {

    @Autowired
    private PersonService personService;

    @PutMapping("/save")
    public void save(@RequestBody Person person){
        personService.save(PersonMapper.mapperToEntity(person));
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") Long id ){
        return PersonMapper.mapperToPerson(personService.findById(id));
    }

    @GetMapping("/all")
    public List<Person> getAllPersons(){
       return PersonMapper.mapperListTo(personService.findAll());
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id){
        personService.delete(id);
    }

    @DeleteMapping("/all")
    public void deleteAllPersons(){
        personService.deleteAll();
    }

}
