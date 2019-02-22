package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientService {
    List<Person> personList =new ArrayList<>();
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
                " Last Name:<br>\n" +
                "  <input type=\"text\" name=\"lastName\" value=\" \">\n" +
                "  <br>\n" +
                " Number:<br>\n" +
                "  <input type=\"text\" name=\"number\" value=\" \">\n" +
                "  <br>\n" +
                " Gender:<br>\n" +
                "  <input type=\"text\" name=\"gender\" value=\" \">\n" +
                "  <br><br>\n" +
                " PhoneType(cellPhoneNumber or phoneNumber):<br>\n" +
                "  <input type=\"text\" name=\"typePhone\" value=\" \">\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> \n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

//    List<String> nameList = new ArrayList<>();
//    List<String> number = new ArrayList<>();
//    List<String> lastName= new ArrayList<>();



    @RequestMapping("/add")
    public String addToPhoneBook(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "number") String number,
                                 @RequestParam (name = "lastName") String lastName,
                                 @RequestParam (name = "gender") Gender gender ,
                                 @RequestParam (name = "typePhone") TypePhone typePhone) {
//        this.nameList.add(name);
//        this.number.add(number);
//        this.lastName.add(lastName);

      //  Person person=new Person(name,lastName,number,gender,typePhone);
        personList.add(new Person(name,lastName,number,gender,typePhone));


        return "successfully added";
    }

    @RequestMapping("/show")
    public List<String> show() {

        List<String> myList = new ArrayList<>();
        for (int i = 0; i < personList.size(); i++) {
            myList.add(personList.get(i).toString());
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
    public String search(@RequestParam(name = "name") String name) {
        String searchResult = null;
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getName().equals(name))
                searchResult = this.personList.get(i).toString();
            else
                searchResult = "Not Founded";


        }
        return searchResult;
    }

}

