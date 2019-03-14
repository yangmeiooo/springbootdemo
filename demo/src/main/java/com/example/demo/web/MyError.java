package com.example.demo.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyError implements ErrorController {

    private static final String PATH="/error";

    @RequestMapping(value = PATH)
    public String error(){

        return "error handing";

    }


    @Override
    public String getErrorPath() {
        return PATH;
    }
}
