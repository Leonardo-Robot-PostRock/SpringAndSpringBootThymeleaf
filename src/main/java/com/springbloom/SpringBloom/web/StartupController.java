package com.springbloom.SpringBloom.web;

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

    @GetMapping("/")
    public String start(Model model){
        log.info("Ejecutando el controlador Spring MVC");

        //model.addAttribute("persons", persons);persons

        return "index";
    }
}
