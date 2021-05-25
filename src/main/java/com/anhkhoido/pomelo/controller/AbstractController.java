package com.anhkhoido.pomelo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class AbstractController<T> {

    @GetMapping(path = "/findAll")
    public abstract Iterable<T> findAll();

    @DeleteMapping(path = "/deleteAll")
    public abstract void deleteAll();

}
