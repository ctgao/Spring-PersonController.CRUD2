package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonRepository people;

    @RequestMapping("/people")
    ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(people.save(p), HttpStatus.CREATED);
    }

    @RequestMapping("/people/{id}")
    ResponseEntity<Person> getPerson(@PathVariable Long id){
        Person p = people.findById(id).get();
        if(p == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping("/people")
    ResponseEntity<List<Person>> getPersonList(){
        List<Person> personList = new ArrayList<>();
        people.findAll().forEach(personList::add);
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @RequestMapping("/people/{id}")
    ResponseEntity<Person> updatePerson(@RequestBody Person p){
//        return people.save(p);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/people/{id}")
    ResponseEntity deletePerson(@PathVariable Long id){
        people.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
