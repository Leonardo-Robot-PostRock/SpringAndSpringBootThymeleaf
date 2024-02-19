/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springbloom.SpringBloom.dao;

import com.springbloom.SpringBloom.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mrRobot
 */

public interface PersonDao extends CrudRepository<Person, Long>{
    
}
