package com.springbloom.SpringBloom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class StartupController {
    @Value("${index.greeting}")
    private String greeting;

    @GetMapping("/")
    public String start(Model model){
        var message = "Message con Thymeleaf2";
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("message", message);
        model.addAttribute("greeting", greeting);
        log.debug("más detalle del controlador");
        return "index";
    }
}
