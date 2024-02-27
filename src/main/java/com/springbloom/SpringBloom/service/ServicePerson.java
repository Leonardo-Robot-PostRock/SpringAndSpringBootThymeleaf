
package com.springbloom.SpringBloom.service;

import com.springbloom.SpringBloom.domain.Person;
import java.util.List;

/**
 *
 * @author mrRobot
 */
public interface ServicePerson {
    public List<Person> listPersons();
    
    public void save(Person person);
    public void delete(Person person);
    public Person findPerson(Person person);
    
}
