package com.schneider.demo.mapper;

import com.schneider.demo.dto.Person;
import com.schneider.demo.entity.PersonEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonMapper {

    public static Person mapperToPerson( Optional<PersonEntity> personEntity){
        return Person.builder()
                .id(personEntity.map(PersonEntity::getId).orElse(null))
                .name(personEntity.map(PersonEntity::getName).orElse(null))
                .age(personEntity.map(PersonEntity::getAge).orElse(null))
                .build();
    }

    public static PersonEntity mapperToEntity(Person person){
        return PersonEntity.builder()
                .id(person.getId())
                .name(person.getName())
                .age(person.getAge())
                .build();
    }

    public static List<Person> mapperListTo(List<PersonEntity> personsEntity){
        return personsEntity.stream()
                .map(personEntity-> mapperToPerson(Optional.of(personEntity)))
                .collect(Collectors.toList());
    }
}
