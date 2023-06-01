package ru.neoflex.practice.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.practice.exceptions.ResourceNotFoundException;
import ru.neoflex.practice.model.Operation;
import ru.neoflex.practice.repository.OperationRepository;
import java.util.List;

@RestController
@RequestMapping("/data")
public class OperationController {
    @Autowired
    private OperationRepository operationRepository;

    @GetMapping("/operations")
    public List<Operation> getAllOperations(){
        return operationRepository.findAll();
    }

    @GetMapping("/operations/{id}")
    public ResponseEntity<Operation> getOperationById(@PathVariable("id") Long operationId)
    throws ResourceNotFoundException {
        Operation operation = operationRepository.findById(operationId)
                .orElseThrow(()-> new ResourceNotFoundException("Operation not found for this id :: " + operationId));
        return ResponseEntity.ok().body(operation);
    }

    @PostMapping("/operations")
    public Operation createOperation(@Valid @RequestBody Operation operation){
        return operationRepository.save(operation);
    }
}
