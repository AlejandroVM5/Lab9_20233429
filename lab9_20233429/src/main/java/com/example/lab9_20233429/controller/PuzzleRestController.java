package com.example.lab9_20233429.controller;

import com.example.lab9_20233429.entity.StfPuzzleSv;
import com.example.lab9_20233429.repository.StfPuzzleSvRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

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
    public ResponseEntity<Map<String, Object>> obtenerEstadoActual() {
        Map<String, Object> response = new HashMap<>();
        List<StfPuzzleSv> filas = repository.findAll();

        if (!filas.isEmpty()) {
            StfPuzzleSv actual = filas.get(0);
            response.put("active", true);
            response.put("stfGameBoardStructure", actual.getStfGameBoardStructure());
            response.put("image", actual.getImage());
        } else {
            response.put("active", false);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> guardarOActualizarEstado(@RequestBody StfPuzzleSv datos) {
        Map<String, Object> response = new HashMap<>();
        //En caso el movimiento que hagamos solo se envia la nueva estructura conservamos la imagen previa
        String imagenActual  =datos.getImage();
        if(imagenActual==null || imagenActual.isEmpty()){
            List<StfPuzzleSv> existentes = repository.findAll();
            if (!existentes.isEmpty()) {
                imagenActual = existentes.get(0).getImage();
            }
        }


        //Como el board structure es primario y en la tabla solo debe hacer una fila eliminamos la anterior y ponemos la
        //actualizada
        repository.deleteAll();
        StfPuzzleSv nuevoEstado = new StfPuzzleSv(datos.getStfGameBoardStructure(), imagenActual);
        repository.save(nuevoEstado);
        response.put("result", "Success");
        response.put("stfGameBoardStructure", nuevoEstado.getStfGameBoardStructure());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<Map<String, Object>> reiniciarJuego() {
        repository.deleteAll();
        Map<String, Object> response = new HashMap<>();
        response.put("result", "reset");
        return ResponseEntity.ok(response);
    }

}
