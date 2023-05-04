package com.jean.alura.flix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @GetMapping
    public void cadastrar(){
        System.out.println("Ola terra plana");
    }
}
