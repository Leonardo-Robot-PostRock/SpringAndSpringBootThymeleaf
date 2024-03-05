package com.springbloom.SpringBloom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author mrRobot
 */
public class EncryptionPassword {

    public static void main(String[] args) {

        var password = "123";
        System.out.println("password: " + password);
        System.out.println("password encrypting: " + encryptPassword(password));
    }

    public static String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
