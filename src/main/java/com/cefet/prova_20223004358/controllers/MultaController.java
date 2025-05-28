package com.cefet.prova_20223004358.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cefet.prova_20223004358.dto.MultaDTO;
import com.cefet.prova_20223004358.services.MultaService;

@RestController
@RequestMapping("/multas")
public class MultaController {

     @Autowired
    private MultaService multaService;


     // GET /multas
    @GetMapping
    public ResponseEntity<List<MultaDTO>> findAll() {
        List<MultaDTO> lista = multaService.findAll();
        return ResponseEntity.ok(lista);
    }

     // GET /multas/{id} - retorna um multa por ID
    @GetMapping("/{id}")
    public ResponseEntity<MultaDTO> findById(@PathVariable Long id) {
        MultaDTO dto = multaService.findById(id);
        return ResponseEntity.ok(dto);
    }

      // POST /multas - cadastra um nova multa
    @PostMapping
    public ResponseEntity<MultaDTO> insert(@RequestBody MultaDTO dto) {
        MultaDTO novo = multaService.insert(dto);
        return ResponseEntity.ok(novo);
    }


    // PUT /multas/{id} - atualiza um carro existente
    @PutMapping("/{id}")
    public ResponseEntity<MultaDTO> update(@PathVariable Long id, @RequestBody MultaDTO dto) {
        MultaDTO atualizado = multaService.update(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    // DELETE /carros/{id} - remove um carro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        multaService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
