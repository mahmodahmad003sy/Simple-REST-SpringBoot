package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {

        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    int deletePersonByUuid(UUID id);

    Optional<Person> getPersonByUuid(UUID id);

    int updatePersonByUuid(UUID id, Person person);

    List<Person> getAllPersons();

}
