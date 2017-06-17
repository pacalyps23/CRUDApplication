package io.zipcoder.controller;

import io.zipcoder.person.Person;
import io.zipcoder.repo.PersonRepo;
import io.zipcoder.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by luisgarcia on 6/15/17.
 */

@RestController
@RequestMapping("/person")
public class PersonController
{

    @Autowired //makes it loosely coupled
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Person>> getAllPeople()
    {
        if(personService.getAllPeople() == null)
        {
            return new ResponseEntity<Iterable<Person>>(HttpStatus.NOT_FOUND);
        }
       return new ResponseEntity<Iterable<Person>>(personService.getAllPeople(), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity <Person> getStudentById(@PathVariable("id") int id)
    {
        if(personService.getPersonById(id) == null)
        {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Person>(personService.getPersonById(id), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Person> update(@RequestBody Person updatedPerson)
    {
        if(updatedPerson == null)
        {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        else
        {
            personService.updatePerson(updatedPerson);
            return new ResponseEntity<Person>(HttpStatus.OK);
        }


    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Person> add(@RequestBody Person newPerson)
    {
        return new ResponseEntity<Person>(personService.add(newPerson), HttpStatus.CREATED);
    }



    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> delete(@PathVariable("id") int id)
    {
        if(personService.getAllPeople() == null)
        {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        else
        {
            personService.delete(id);
            return new ResponseEntity<Person>(HttpStatus.OK);
        }

    }




}
