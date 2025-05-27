package com.cefet.prova_20223004358.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.prova_20223004358.dto.CarroDTO;
import com.cefet.prova_20223004358.dto.PessoaDTO;
import com.cefet.prova_20223004358.entities.Carro;
import com.cefet.prova_20223004358.entities.Pessoa;
import com.cefet.prova_20223004358.repositories.CarroRepository;
import com.cefet.prova_20223004358.repositories.PessoaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private CarroRepository carroRepository;

    //Buscar Todos
    public List<PessoaDTO> findAll(){
        List<Pessoa> listaPessoas = pessoaRepository.findAll();
        return listaPessoas.stream().map(PessoaDTO::new).toList();
    }

     //Buscar por Id
        public PessoaDTO findById(Long id){
        Pessoa pessoa = pessoaRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + id));
        return new PessoaDTO(pessoa);
    }

    //Inserir Pessoa
     public PessoaDTO insert(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return new PessoaDTO(pessoaSalva);
     }

       // Remover pessoa
    public void delete(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + id));

        List<Carro> carros = carroRepository.findByPessoaId(id);
        carroRepository.deleteAll(carros);

        pessoaRepository.delete(pessoa);
    }

        // Atualizar pessoa
    public PessoaDTO update(Long id, PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + id));

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf()); 
        Pessoa pessoaAtualizada = pessoaRepository.save(pessoa);
        return new PessoaDTO(pessoaAtualizada);
    }

    // Lista os carros associados à pessoa identificada por {id}
    public List<CarroDTO> listaDeCarrosRelacionadosPessoa (Long id){
        List<Carro> carrosPorPessoa = carroRepository.findByPessoaId(id);
        return carrosPorPessoa.stream().map(CarroDTO::new).toList();
    }
}
