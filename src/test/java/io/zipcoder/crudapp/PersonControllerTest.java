package io.zipcoder.crudapp;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.zipcoder.CRUDApplication;
import io.zipcoder.controller.PersonController;
import io.zipcoder.person.Person;
import io.zipcoder.repo.PersonRepo;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

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
        ResponseEntity<Iterable<Person>> result = controller.getAllPeople();
        String expected = "200";
        int expected2 = 3;



        //when
        String actual = result.getStatusCode().toString();
        int actual2 = Lists.newArrayList(result.getBody()).size();

        //then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testGetPersonById()
    {
        //Given
        controller.add(person1);
        controller.add(person2);
        controller.add(person3);
        ResponseEntity result = controller.getPersonById(3);
        int expected = 200;
        String expected2 = "Dan";

        //When
        int actual = result.getStatusCodeValue();
        Person actualPerson = (Person)result.getBody();
        String actual2 = actualPerson.getName();


        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testUpdatePerson()
    {
        //Given
        controller.add(person1);
        Person updatedPerson = new Person(1, "Paco Garcia", 31); //added last name
        String expected = "Paco Garcia";

        //When

        String actual = controller.getPersonById(1).getBody().getName();

        


    }

    @Test
    public void deletePersonTest()
    {
        //Given
        controller.add(person1);
        controller.add(person2);
        controller.add(person3);
        controller.delete(1);
        ResponseEntity<Iterable<Person>> result = controller.getAllPeople();
        ArrayList personList = Lists.newArrayList(result.getBody());
        Person first = (Person)personList.get(0);
        int expected = 2;
        String expected2 = "Murphy";

        //When
        int actual = personList.size();
        String actual2 = first.getName();

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);

    }
}
