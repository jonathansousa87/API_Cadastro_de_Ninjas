package br.com.dev.cadastroDeNinjas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping
    public String nomeNinja(){
        return "Olá ninja";
    }
}
