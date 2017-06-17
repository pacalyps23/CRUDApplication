package io.zipcoder.crudapp;

import io.zipcoder.CRUDApplication;
import io.zipcoder.controller.PersonController;
import io.zipcoder.person.Person;
import io.zipcoder.repo.PersonRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by luisgarcia on 6/16/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CRUDApplication.class)
public class PersonControllerTest
{
    @Autowired
    PersonController controller;
    @Autowired
    PersonRepo repo;
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
    public void testGetAll()
    {
        //given
        controller.add(person1);
        controller.add(person2);
        controller.add(person3);
        ResponseEntity<Iterable<Person>> code = controller.getAllPeople();
        String expected = "200";

        //when
        String atcual = code.getStatusCode().toString();

        //then
        Assert.assertEquals(expected, atcual);
    }
}
