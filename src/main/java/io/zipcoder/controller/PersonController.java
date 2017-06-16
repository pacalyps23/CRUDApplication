package io.zipcoder.controller;

import io.zipcoder.person.Person;
import io.zipcoder.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Iterable<Person> getAllPeople()
    {
       return personService.getAllPeople();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Person getStudentById(@PathVariable("id") int id)
    {
        return personService.getPersonById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Person updatedPerson)
    {
        personService.updatePerson(updatedPerson);
    }

    
}
