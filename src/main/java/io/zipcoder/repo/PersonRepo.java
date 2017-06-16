package io.zipcoder.repo;

import io.zipcoder.person.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by luisgarcia on 6/15/17.
 */

public interface PersonRepo extends CrudRepository<Person, Integer>
{

}