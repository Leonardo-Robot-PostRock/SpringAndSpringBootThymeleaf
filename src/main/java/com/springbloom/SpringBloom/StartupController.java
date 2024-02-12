package com.springbloom.SpringBloom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@Slf4j
public class StartupController {
    @Value("${index.greeting}")
    private String greeting;

    @GetMapping("/")
    public String start(Model model){
        var message = "Message with Thymeleaf";
        var person = new Person();

        person.setName("Leonardo");
        person.setSurname("Puebla");
        person.setEmail("leonardo@gmail.com");
        person.setPhone("234123123");

        var person2 = new Person();

        person2.setName("Ada");
        person2.setSurname("Crain");
        person2.setEmail("ada@gmail.com");
        person2.setPhone("2341245432");

        log.info("Ejecutando el controlador Spring MVC");

//        var persons = new ArrayList<Person>();
//        persons.add(person);

        var persons = Arrays.asList(person, person2);

//        var persons = new ArrayList<>();

        model.addAttribute("message", message);
        model.addAttribute("greeting", greeting);
//        model.addAttribute("person", person);
        model.addAttribute("persons", persons);

//        log.debug("más detalle del controlador");
        return "index";
    }
}
