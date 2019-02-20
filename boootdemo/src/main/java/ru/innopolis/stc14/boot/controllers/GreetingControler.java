package ru.innopolis.stc14.boot.controllers;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class GreetingControler {

    @RequestMapping
    public String greeting(
            @RequestParam(value = "name",
            required = false,
            defaultValue = "World"
    ) String name,
    Model model){
        model.addAttribute("name", name);
        return "greeting";

    }
}
