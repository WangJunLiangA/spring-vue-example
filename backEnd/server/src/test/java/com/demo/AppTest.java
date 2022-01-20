package com.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * Unit test for simple App.dao
 */
@SpringBootTest
public class AppTest 
{



    @Test
    public void EncodePassword(){
        PasswordEncoder pe=new BCryptPasswordEncoder();
        String password= pe.encode("12345678");
        Boolean password2=pe.matches("12345678",password);
        System.out.println(password);
        System.out.println(password2);
    }
}
