package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    PersonRepository people;

    @RequestMapping(value = "/people", method = RequestMethod.POST)
//    @PostMapping("/people")
    Person createPerson(@RequestBody Person p){
        return people.save(p);
    }
//    ResponseEntity<Person> createPerson(@RequestBody Person p){
//        return new ResponseEntity<>(people.save(p), HttpStatus.CREATED);
//    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    Person getPerson(@PathVariable Long id){
        if(people.findById(id).isPresent()){
            return people.findById(id).get();
        }
        return null;
    }
//    ResponseEntity<Person> getPerson(@PathVariable Long id){
//        if(!people.findById(id).isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(people.findById(id).get(), HttpStatus.OK);
//    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
//    ResponseEntity<List<Person>> getPersonList(){
//        List<Person> personList = new ArrayList<>();
//        people.findAll().forEach(personList::add);
//        return new ResponseEntity<>(personList, HttpStatus.OK);
//    }
    List<Person> getPersonList(){
        List<Person> personList = new ArrayList<>();
        people.findAll().forEach(personList::add);
        return personList;
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    Person updatePerson(@RequestBody Person p){
        return people.save(p);
    }
//    ResponseEntity<Person> updatePerson(@RequestBody Person p, @PathVariable Long id){
//        Person personGot = people.findById(id).get();
//        if(personGot == null){
//            return createPerson(p);
//        }
//        return new ResponseEntity<>(people.save(p), HttpStatus.OK);
//    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    void deletePerson(@PathVariable Long id){
        people.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
