package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebServ {
    @RequestMapping("/form")
    public String form() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>HTML Forms</h2>\n" +
                "\n" +
                "<form action=\"http://localhost:8080/add\">\n" +
                "  Name:<br>\n" +
                "  <input type=\"text\" name=\"name\" value=\" \">\n" +
                "  <br>\n" +
                " Number:<br>\n" +
                "  <input type=\"text\" name=\"number\" value=\" \">\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> \n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

    List<String> nameList = new ArrayList<>();
    List<String> number = new ArrayList<>();


    @RequestMapping("/add")
    public String addToPhoneBook(@RequestParam(name = "name") String name, @RequestParam(name = "number") String number) {
        this.nameList.add(name);
        this.number.add(number);

        return "true";
    }

    @RequestMapping("/show")
    public List<String> show() {

        List<String> myList = new ArrayList<>();
        for (int i = 0; i < nameList.size(); i++) {
            myList.add(nameList.get(i) + " " + number.get(i));
        }

        return myList;

    }
    @RequestMapping("/searchForm")
    public String searchForm() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>HTML Forms</h2>\n" +
                "\n" +
                "<form action=\"http://localhost:8080/search\">\n" +
                "  Name:<br>\n" +
                "  <input type=\"text\" name=\"name\" value=\" \">\n" +
                "  <br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> \n" +
                "\n" +
                "</body>\n" +
                "</html>";}
    @RequestMapping("/search")
    public String search() {
        String searchResult = null;
        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).equals(this.nameList)) {
                searchResult = this.number.get(i);
            }
            else
                 searchResult="Not Founded";
        }
        return searchResult;
    }

}

