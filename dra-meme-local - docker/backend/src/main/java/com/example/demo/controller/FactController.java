package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FactService;
import com.example.demo.dto.FactDTO;

@RestController
@RequestMapping("/fact")
public class FactController {
    @Autowired
    private FactService factService;

    public FactController(FactService factService) {
        this.factService = factService;
    }
    
    @GetMapping("fact")
    public ResponseEntity<List<FactDTO>> getFacts(){
        return new ResponseEntity<List<FactDTO>>(factService.getFacts(), HttpStatus.OK);
    }
}
