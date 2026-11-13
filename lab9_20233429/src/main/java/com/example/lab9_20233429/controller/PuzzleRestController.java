package com.example.lab9_20233429.controller;

import com.example.lab9_20233429.entity.StfPuzzleSv;
import com.example.lab9_20233429.repository.StfPuzzleSvRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/api/puzzle")
public class PuzzleRestController {

    private final StfPuzzleSvRepository repository;
    public PuzzleRestController(StfPuzzleSvRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Map<String,Object>> ObtenerEstadoActual() {
        Map<String,Object> response = new HashMap<>();
        List<StfPuzzleSv> filas = repository.findAll();

        
    }

}
