package com.example.lab04;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Cashier {
    private List<Change> changes = new ArrayList<>();

    @RequestMapping(value = "/getChange/{change}")
    public List<Change> getChange(@PathVariable("change") int change){
        changes.clear();
        Change c = new Change();
        int b1000 = (change / 1000);
        int b500 = (change - (b1000 * 1000)) / 500;
        int b100 = (change - (b1000 * 1000) - (b500 * 500)) / 100;
        int b20 = (change - (b1000 * 1000) - (b500 * 500) - (b100 * 100)) / 20;
        int b10 = (change - (b1000 * 1000) - (b500 * 500) - (b100 * 100) - (b20 * 20)) / 10;
        int b5 = (change - (b1000 * 1000) - (b500 * 500) - (b100 * 100) - (b20 * 20) - (b10 * 10)) / 5;
        int b1 = (change - (b1000 * 1000) - (b500 * 500) - (b100 * 100) - (b20 * 20) - (b10 * 10) - (b5 * 5));
        c.setB1(b1);
        c.setB5(b5);
        c.setB10(b10);
        c.setB20(b20);
        c.setB100(b100);
        c.setB500(b500);
        c.setB1000(b1000);
        changes.add(c);
        return changes;
    };


}
