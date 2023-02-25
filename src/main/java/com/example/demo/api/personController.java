package com.example.demo.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.personService;

@RequestMapping("/api/v1/person")
@RestController
public class personController {

    private final personService personService;

    @Autowired
    public personController(personService personService) {
        super();

        this.personService = personService;
    }

    @PostMapping
    public void addPersone(@RequestBody Person person) {
        personService.addPerson(person);

    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getList();

    }

    @DeleteMapping(path = "{id}")
    public int deletePerson(@PathVariable("id") UUID id) {
        return personService.deletePerson(id);

    }

    @GetMapping(path = "{id}")
    public Optional<Person> getPersonByUuid(@PathVariable("id") UUID id) {
        System.out.println(id);
        return personService.getByUuid(id);

    }

    @PutMapping(path = "{id}")
    public int UpdatePersonByUuid(@PathVariable("id") UUID id, @RequestBody Person person) {
        return personService.update(id, person);

    }

}
