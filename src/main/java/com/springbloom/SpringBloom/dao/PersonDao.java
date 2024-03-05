package com.springbloom.SpringBloom.dao;

import com.springbloom.SpringBloom.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mrRobot
 */

public interface PersonDao extends JpaRepository<Person, Long>{
    
}
