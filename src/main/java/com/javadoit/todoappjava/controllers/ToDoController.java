package com.javadoit.todoappjava.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ToDoController {
    private final Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @GetMapping("/")
    public ModelAndView index() {
        logger.debug("request to GET index");
        return new ModelAndView("index");
    }
}
