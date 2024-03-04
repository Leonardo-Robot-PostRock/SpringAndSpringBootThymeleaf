package com.springbloom.SpringBloom.web;

import com.springbloom.SpringBloom.domain.Person;
import com.springbloom.SpringBloom.service.ServicePerson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class StartupController {

    //Se injecta la capa de servicio
    @Autowired
    private ServicePerson servicePerson;//Spring busca una clase que implemente la interface ServicePerson. 

    @GetMapping("/")
    public String start(Model model) {
        var persons = servicePerson.listPersons();

        log.info("Ejecutando el controlador Spring MVC");

        model.addAttribute("persons", persons);

        return "index";
    }

    @GetMapping("/add")
    public String add(Person person) {
        return "modify";
    }

    @PostMapping("/save")
    public String save(Person person) {
        servicePerson.save(person);
        return "redirect:/";
    }

    @GetMapping("/edit/{idPerson}")
    public String edit(Person person, Model model) {
        person = servicePerson.findPerson(person);
        model.addAttribute("person", person);
        return "modify";
    }
    
    @GetMapping("/delete")
    public String delete(Person person){
        servicePerson.delete(person);
        return "redirect:/";
    }
}
