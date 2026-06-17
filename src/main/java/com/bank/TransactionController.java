package com.bank;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TransactionController {

    @GetMapping("/health")
    public Map<String, String> health() {

        Map<String, String> response = new HashMap<>();

        response.put("status", "UP");
        response.put("environment", "DEV");
        response.put("version", "1.0");

        return response;
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransaction(@PathVariable String id) {

        return new Transaction(
                id,
                5000.0,
                "INR",
                "SUCCESS"
        );
    }

    @PostMapping("/transaction")
    public Transaction createTransaction(
            @RequestBody Transaction transaction) {

        transaction.setStatus("SUCCESS");

        return transaction;
    }
    
    
}
