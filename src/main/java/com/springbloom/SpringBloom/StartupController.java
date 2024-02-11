package com.springbloom.SpringBloom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class StartupController {


    @GetMapping("/")
    public String start(){
        log.info("Ejecutando el controlador Spring MVC");
        log.debug("más detalle del controlador");
        return "index";
    }
}
