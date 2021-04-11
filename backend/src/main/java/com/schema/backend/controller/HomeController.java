package com.schema.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

    @GetMapping("/")
    public String home(){
        return ("Bem vindo ao nosso aplicativo, sinta-se livre para explorar as novidades, caso seja de seu interesse, considere se cadastrar para ter mais acesso!");
    }
    
}
