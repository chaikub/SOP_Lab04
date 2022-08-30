package com.example.lab04;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathAPI {
    @RequestMapping(value = "/myPlus/{n1}/{n2}", method = RequestMethod.GET)
    public double myPlus(@PathVariable("n1") double x,
                      @PathVariable("n2") double y){
        return x + y;
    }
    @RequestMapping(value = "/myMinus/{n1}/{n2}", method = RequestMethod.GET)
    public double myMinus(@PathVariable("n1") double x,
                         @PathVariable("n2") double y){
        return x - y;
    }
    @RequestMapping(value = "/myDivide/{n1}/{n2}", method = RequestMethod.GET)
    public double myDivide(@PathVariable("n1") double x,
                          @PathVariable("n2") double y){
        return x / y;
    }
    @RequestMapping(value = "/myMulti/{n1}/{n2}", method = RequestMethod.GET)
    public double myMulti(@PathVariable("n1") double x,
                          @PathVariable("n2") double y){
        return x * y;
    }
    @RequestMapping(value = "/myMod/{n1}/{n2}", method = RequestMethod.GET)
    public double myMod(@PathVariable("n1") double x,
                          @PathVariable("n2") double y){
        return x % y;
    }
    @RequestMapping(value = "/myMax/{n1}/{n2}", method = RequestMethod.GET)
    public double myMax(@PathVariable("n1") double x,
                          @PathVariable("n2") double y){
        return Math.max(x,y);
    }
}
