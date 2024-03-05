package com.springbloom.SpringBloom.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author mrRobot
 */
@Component
public class BCPasswordEncoder {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public BCryptPasswordEncoder passwordEncoder() {
        return encoder;
    }

    public String encodePassword(String password) {
        return encoder.encode(password);
    }
}
