package com.springbloom.SpringBloom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springbloom.SpringBloom.domain.Account;

/**
 *
 * @author mrRobot
 */
public interface UserDao extends JpaRepository<Account, Long>{
    Account findByUsername(String username);
}


