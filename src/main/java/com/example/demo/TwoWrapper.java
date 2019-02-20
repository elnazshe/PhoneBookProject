package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class TwoWrapper {

    private List<String> nameList = new ArrayList<>();
    private List<String> number = new ArrayList<>();

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<String> getNumber() {
        return number;
    }

    public void setNumber(List<String> number) {
        this.number = number;
    }
}
