package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;;

@Repository("fake-DAO")
public class fakePersonDataAccessService implements personDao {
    private static List<Person> Db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        Db.add(new Person(id, person.getName()));
        return 0;
    }

    @Override
    public int deletePersonByUuid(UUID id) {
        Optional<Person> personToDelete = getPersonByUuid(id);
        if (personToDelete.isEmpty()) {
            return 0;
        } else {
            Db.remove(personToDelete.get());
            return 1;
        }

    }

    @Override
    public Optional<Person> getPersonByUuid(UUID id) {

        System.out.println(Db.stream());
        System.out.println(Db.stream().filter(person -> person.getId().equals(id)));
        Db.stream().map(person -> {
            System.out.println(person);
            return 0;
        });

        return Db.stream().filter(person -> person.getId().equals(id)).findFirst();

    }

    @Override
    public int updatePersonByUuid(UUID id, Person person) {
        return getPersonByUuid(id).map(p -> {
            int indexToUpadte = Db.indexOf(p);
            if (indexToUpadte >= 0) {
                Db.set(indexToUpadte, person);
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    /*
     * @Override
     * public int updatePersonByUuid(UUID id, Person person) {
     * Optional<Person> found = getPersonByUuid(id);
     * if (found.isEmpty()) {
     * return 0;
     * }
     * 
     * int indexToUpdate = Db.indexOf(found.get());
     * if (indexToUpdate >= 0) {
     * Db.set(indexToUpdate, person);
     * return 1;
     * }
     * return 0;
     * }
     */

    @Override
    public List<Person> getAllPersons() {

        return Db;
    }

}