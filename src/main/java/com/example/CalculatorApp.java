package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class CalculatorApp {
    private final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApp.class, args);
    }

    @GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b) {
        return String.format("%d + %d = %d", a, b, calculator.add(a, b));
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam int a, @RequestParam int b) {
        return String.format("%d - %d = %d", a, b, calculator.subtract(a, b));
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam int a, @RequestParam int b) {
        return String.format("%d * %d = %d", a, b, calculator.multiply(a, b));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam int a, @RequestParam int b) {
        try {
            return String.format("%d / %d = %d", a, b, calculator.divide(a, b));
        } catch (ArithmeticException e) {
            return "Error: " + e.getMessage();
        }
    }
}