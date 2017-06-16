package io.zipcoder.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by luisgarcia on 6/15/17.
 */

@Entity
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    private String name;
    private int age;


    public Person(Integer id, String name, Integer age)
    {
        this.id = id;
        this. name = name;
        this. age = age;
    }

    public Person(){}

    public Integer getId()
    {
        return id;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }


}
