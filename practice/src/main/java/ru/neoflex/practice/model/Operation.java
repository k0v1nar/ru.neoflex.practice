package ru.neoflex.practice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "operations")
public class Operation {
    private long id;
    private LocalDateTime dateTime;
    private String operation;
    private int a;
    private int b;
    private int result;

    public Operation(){

    }

    public Operation(LocalDateTime dateTime, String operation, int a, int b, int result){
        this.dateTime = dateTime;
        this.operation = operation;
        this.a = a;
        this.b = b;
        this.result = result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    @Column(name = "date", nullable = false)
    public LocalDateTime getDateTime(){
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    @Column(name = "operation", nullable = false)
    public String getOperation(){
        return this.operation;
    }
    public void setOperation(String operation){
        this.operation = operation;
    }

    @Column(name = "a", nullable = false)
    public int getA(){
        return a;
    }
    public void setA(int a){
        this.a = a;
    }

    @Column(name = "b", nullable = false)
    public int getB(){
        return b;
    }
    public void setB(int b){
        this.b = b;
    }

    @Column(name = "result", nullable = false)
    public int getResult(){
        return result;
    }
    public void setResult(int result){
        this.result = result;
    }
}
