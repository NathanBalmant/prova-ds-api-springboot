package com.cefet.prova_20223004358.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.prova_20223004358.dto.CarroDTO;
import com.cefet.prova_20223004358.dto.MultaDTO;
import com.cefet.prova_20223004358.entities.Carro;
import com.cefet.prova_20223004358.entities.Multa;
import com.cefet.prova_20223004358.entities.Pessoa;
import com.cefet.prova_20223004358.repositories.CarroRepository;
import com.cefet.prova_20223004358.repositories.MultaRepository;
import com.cefet.prova_20223004358.repositories.PessoaRepository;



import jakarta.persistence.EntityNotFoundException;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

      @Autowired
    private MultaRepository multaRepository;

    // Buscar todos os carros
    public List<CarroDTO> findAll() {
        return carroRepository.findAll()
                .stream()
                .map(CarroDTO::new)
                .toList();
    }

    // Buscar carro por ID
    public CarroDTO findById(Long id) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado com ID: " + id));
        return new CarroDTO(carro);
    }

    //Inserir carro
    public CarroDTO insert(CarroDTO carroDTO){
    Pessoa pessoa = pessoaRepository.findByCpf(carroDTO.getCpfPessoa());
    
    Carro carro = new Carro();
    carro.setPlaca(carroDTO.getPlaca());
    carro.setPessoa(pessoa);
    carro.setPontuacao(0.0); 

    carro = carroRepository.save(carro);
    return new CarroDTO(carro);
}

        // Atualizar carro
    public CarroDTO update(Long id, CarroDTO dto) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado com ID: " + id));

        Pessoa pessoa = pessoaRepository.findByCpf(dto.getCpfPessoa());

        carro.setPlaca(dto.getPlaca());
        carro.setPessoa(pessoa);

        carro = carroRepository.save(carro);
        return new CarroDTO(carro);
    }

     // Remover carro
    public void delete(Long id) {
        if (!carroRepository.existsById(id)) {
            throw new EntityNotFoundException("Carro não encontrado com ID: " + id);
        }
        carroRepository.deleteById(id);
    }

    // Lista os carros associados à pessoa identificada por {id}
    public List<MultaDTO> listaDeMultasRelacionadosCarro (Long id){
        List<Multa> multasPorCarro = multaRepository.findByCarroId(id);
        return multasPorCarro.stream().map(MultaDTO::new).toList();
    }

}
