package ru.neoflex.practice.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.neoflex.practice.model.Operation;
import java.time.LocalDateTime;

import static org.springframework.http.RequestEntity.post;

@RestController
public class CalcController {
    @GetMapping("/plus/{a}/{b}")
    public int GetPlus(@PathVariable("a") int a, @PathVariable("b") int b){
        SaveOperation(new Operation(LocalDateTime.now(), "plus", a,b,a+b));
        return a + b;
    }

    @GetMapping("/minus/{a}/{b}")
    public int GetMinus(@PathVariable("a") int a, @PathVariable("b") int b){
        SaveOperation(new Operation(LocalDateTime.now(), "minus", a,b,a-b));
        return a - b;
    }

    private void SaveOperation(Operation operation){
        RequestEntity.BodyBuilder bodyBuilder = post("http://localhost:8080/data/operations");
        RequestEntity<Operation> request = bodyBuilder.body(operation);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(request, Operation.class);
    }
}
