package com.example.lab04;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Cashier {
    private List<Change> changes = new ArrayList<>();

    @RequestMapping(value = "/getChange/{change}")
    public List<Change> getChange(){
        return changes;
    };
}
