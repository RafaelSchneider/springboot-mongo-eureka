package com.schneider.demo.service;

import com.schneider.demo.entity.PersonEntity;
import com.schneider.demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonService {

    private PersonRepository repository;

    public void save(PersonEntity personEntity){
        repository.save(personEntity);
    }

    public Optional<PersonEntity> findById(Long id){
        return repository.findById(id);
    }

    public List<PersonEntity> findAll(){
        return repository.findAll();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void deleteAll(){
        repository.deleteAll();
    }
}
