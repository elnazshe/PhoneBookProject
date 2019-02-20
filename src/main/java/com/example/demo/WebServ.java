package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebServ {

    List<String> nameList = new ArrayList<>();

    @RequestMapping("/add")
    public String addToPhoneBook (@RequestParam(name="name") List<String> name ){
        this.nameList=name;
        return "true";
    }

    @RequestMapping ("/show")
    public List<String> show (){

        return nameList ;

    }
}
