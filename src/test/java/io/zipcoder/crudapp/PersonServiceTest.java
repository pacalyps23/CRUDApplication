package io.zipcoder.crudapp;

import io.zipcoder.CRUDApplication;
import io.zipcoder.person.Person;
import io.zipcoder.repo.PersonRepo;
import io.zipcoder.services.PersonService;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by luisgarcia on 6/16/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CRUDApplication.class)
public class PersonServiceTest
{

    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private PersonService personService;
    Person person1;
    Person person2;
    Person person3;

    @Before
    public void setup()
    {
        person1 = new Person(1, "Paco", 31);
        person2 = new Person(2, "Murphy", 30);
        person3 = new Person(3, "Dan", 29);

    }

    @Test
    public void addPersonTest()
    {
        //given
        String expected = "Paco";

        //when
        personService.add(person1);
        String actual = person1.getName();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findPersonByIdTestRepo()
    {
        //given
        personService.add(person1);
        personService.add(person2);
        personService.add(person3);
        String expected = "Murphy";

        //when
        String actual = personRepo.findOne(2).getName();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllPersonTest()
    {
        //given
        personService.add(person1);
        personService.add(person2);
        personService.add(person3);
        int expected = 3;

        Iterable<Person> personList = personRepo.findAll();
        int actual = Lists.newArrayList(personList).size();


        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updatePersonTest()
    {
        //given
        personService.add(person1);
        Person update = new Person(1, "Paco Garcia", 31);
        String expected = "Paco Garcia";

        //when
       personService.updatePerson(update);
       String actual = personRepo.findOne(1).getName();

       //then
       Assert.assertEquals(expected, actual);

    }

    @Test
    public void deletePersonTest()
    {
        //given
        personService.add(person1);
        personService.add(person2);
        personService.add(person3);
        personRepo.delete(1);
        int expected1 = 2;
        boolean expected2 = false;

        //when
        Iterable<Person> personList = personRepo.findAll();
        int actual1 = Lists.newArrayList(personList).size();
        boolean actual2 = personRepo.exists(1);

        //then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);

    }
}
