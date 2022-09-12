package com.example.lab04;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.List;

@Route(value = "index2")
public class CashierView extends VerticalLayout {
    private TextField change, b1000, b500, b100, b20, b10, b5 ,b1;
    private Button calbtn;

    public CashierView(){
        change = new TextField();
        change.setPrefixComponent(new Span("$"));
        b1000 = new TextField();
        b1000.setPrefixComponent(new Span("$1000: "));
        b500 = new TextField();
        b500.setPrefixComponent(new Span("$500: "));
        b100 = new TextField();
        b100.setPrefixComponent(new Span("$200: "));
        b20 = new TextField();
        b20.setPrefixComponent(new Span("$100: "));
        b10 = new TextField();
        b10.setPrefixComponent(new Span("$10: "));
        b5 = new TextField();
        b5.setPrefixComponent(new Span("$5: "));
        b1 = new TextField();
        b1.setPrefixComponent(new Span("$1: "));
        calbtn = new Button("คำนวณเงินทอน");
        add(change, calbtn, b1000, b500, b100, b20, b10, b5, b1);

        calbtn.addClickListener(event ->{
            ObjectMapper mapper = new ObjectMapper();
            int value = Integer.parseInt((change.getValue()));
            String out =  WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/" + value)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            try {
                List<Change> c = Arrays.asList(mapper.readValue(out, Change[].class));
                b1000.setValue(c.get(0).getB1000() + "");
                b500.setValue(c.get(0).getB500() + "");
                b100.setValue(c.get(0).getB100() + "");
                b20.setValue(c.get(0).getB20() + "");
                b10.setValue(c.get(0).getB10() + "");
                b5.setValue(c.get(0).getB5() + "");
                b1.setValue(c.get(0).getB1() + "");
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

    });
    }
}
