package io.zipcoder.crudapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
    String firstName;
    String lastName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
