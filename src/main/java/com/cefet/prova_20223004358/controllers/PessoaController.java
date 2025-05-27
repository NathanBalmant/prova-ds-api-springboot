package com.cefet.prova_20223004358.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cefet.prova_20223004358.dto.CarroDTO;
import com.cefet.prova_20223004358.dto.PessoaDTO;
import com.cefet.prova_20223004358.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    // GET /pessoas
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll() {
        List<PessoaDTO> pessoas = pessoaService.findAll();
        return ResponseEntity.ok(pessoas);
    }

    // GET /pessoas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
        PessoaDTO pessoa = pessoaService.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    // POST /pessoas
    @PostMapping
    public ResponseEntity<PessoaDTO> insert(@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO novaPessoa = pessoaService.insert(pessoaDTO);
        return ResponseEntity.ok(novaPessoa);
    }

    // PUT /pessoas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO atualizada = pessoaService.update(id, pessoaDTO);
        return ResponseEntity.ok(atualizada);
    }

    // DELETE /pessoas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // GET /pessoas/{id}/carros
    @GetMapping("/{id}/carros")
    public ResponseEntity<List<CarroDTO>> listarCarrosPorPessoa(@PathVariable Long id) {
        List<CarroDTO> carros = pessoaService.listaDeCarrosRelacionadosPessoa(id);
        return ResponseEntity.ok(carros);
    }
}
