package com.cefet.prova_20223004358.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cefet.prova_20223004358.dto.CarroDTO;
import com.cefet.prova_20223004358.services.CarroService;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    // GET /carros - retorna todos os carros
    @GetMapping
    public ResponseEntity<List<CarroDTO>> findAll() {
        List<CarroDTO> lista = carroService.findAll();
        return ResponseEntity.ok(lista);
    }

    // GET /carros/{id} - retorna um carro por ID
    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> findById(@PathVariable Long id) {
        CarroDTO dto = carroService.findById(id);
        return ResponseEntity.ok(dto);
    }

    // POST /carros - cadastra um novo carro
    @PostMapping
    public ResponseEntity<CarroDTO> insert(@RequestBody CarroDTO dto) {
        CarroDTO novo = carroService.insert(dto);
        return ResponseEntity.ok(novo);
    }

    // PUT /carros/{id} - atualiza um carro existente
    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> update(@PathVariable Long id, @RequestBody CarroDTO dto) {
        CarroDTO atualizado = carroService.update(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    // DELETE /carros/{id} - remove um carro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
