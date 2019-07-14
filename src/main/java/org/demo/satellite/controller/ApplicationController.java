package org.demo.satellite.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController
{
    @RequestMapping("/")
    public String index()
    {
        return "You've reached the main index";
    }
}
