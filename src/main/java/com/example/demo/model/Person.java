package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Person
 */
public class Person {

    private final UUID id;
    private final String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        super();
        this.name = name;
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

}