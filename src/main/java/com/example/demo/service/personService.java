package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.fakePersonDataAccessService;
import com.example.demo.model.Person;

@Service
public class personService {

    private final fakePersonDataAccessService personDao;

    @Autowired
    public personService(@Qualifier("fake-DAO") fakePersonDataAccessService personDao) {
        super();
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonByUuid(id);
    }

    public Optional<Person> getByUuid(UUID id) {
        return personDao.getPersonByUuid(id);
    }

    public List<Person> getList() {
        return personDao.getAllPersons();
    }

    public int update(UUID id, Person person) {
        return personDao.updatePersonByUuid(id, person);
    }
}
