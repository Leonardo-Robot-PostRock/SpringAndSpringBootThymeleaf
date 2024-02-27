package com.springbloom.SpringBloom.service;

import java.util.List;
import com.springbloom.SpringBloom.dao.PersonDao;
import com.springbloom.SpringBloom.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mrRobot
 */

@Service
public class ServicePersonImplementation implements ServicePerson{

    @Autowired
    private PersonDao personDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Person> listPersons() {
        return (List<Person>) personDao.findAll();
    }

    @Transactional()
    @Override
    public void save(Person person) {
        personDao.save( person);
    }

    @Transactional()
    @Override
    public void delete(Person person) {
        personDao.delete(person);
    }

    @Transactional(readOnly = true)
    @Override
    public Person findPerson(Person person) {
        return personDao.findById(person.getIdPerson()).orElse(null);
    }
}
