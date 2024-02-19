package com.springbloom.SpringBloom.web;

import com.springbloom.SpringBloom.dao.PersonDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class StartupController {
    
    @Autowired
    private PersonDao personDao;
    
    @GetMapping("/")
    public String start(Model model){
        var persons = personDao.findAll();
        
        log.info("Ejecutando el controlador Spring MVC");

        model.addAttribute("persons", persons);

        return "index";
    }
}
