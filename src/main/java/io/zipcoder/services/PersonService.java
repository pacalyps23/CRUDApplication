package io.zipcoder.services;


import io.zipcoder.person.Person;
import io.zipcoder.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luisgarcia on 6/15/17.
 */

@Service
public class PersonService
{
    @Autowired
    private PersonRepo personRepo;

    public Iterable<Person> getAllPeople()
    {
        return personRepo.findAll();
    }

    public Person getPersonById(int id)
    {
        return personRepo.findOne(id);
    }

    public void updatePerson(Person person)
    {
        Person updatedPerson = getPersonById(person.getId());
        updatedPerson.setAge(person.getAge());
        updatedPerson.setName(person.getName());
        personRepo.save(updatedPerson);
    }

    public void delete(int id)
    {
        personRepo.delete(id);
    }

    public Person add(Person newPerson)
    {
        personRepo.save(newPerson);
        return newPerson;
    }

}
