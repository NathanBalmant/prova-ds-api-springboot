package com.cefet.prova_20223004358.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cefet.prova_20223004358.dto.MultaDTO;
import com.cefet.prova_20223004358.entities.Carro;
import com.cefet.prova_20223004358.entities.Multa;
import com.cefet.prova_20223004358.repositories.CarroRepository;
import com.cefet.prova_20223004358.repositories.MultaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MultaService {

     @Autowired
    private MultaRepository multaRepository;

    @Autowired
    private CarroRepository carroRepository;

    // Buscar todas as multas
    public List<MultaDTO> findAll() {
        return multaRepository.findAll()
                .stream()
                .map(MultaDTO::new)
                .toList();
    }

    // Buscar multa por ID
    public MultaDTO findById(Long id) {
        Multa multa = multaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado com ID: " + id));
        return new MultaDTO(multa);
    }

     //Inserir multa
    public MultaDTO insert(MultaDTO multaDTO){
        Carro carro = carroRepository.findById(multaDTO.getIdCarro())
        .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado com ID: " ));
        
        Multa multa = new Multa();
        multa.setPontos(multaDTO.getPontos());
        multa.setCarro(carro);
        Double novasPontos = carro.getPontuacao() + multaDTO.getPontos();
        carro.setPontuacao(novasPontos);
        

        multa = multaRepository.save(multa);
        carro = carroRepository.save(carro);
        return new MultaDTO(multa);

    }

       // Atualizar multa
    public MultaDTO update(Long id, MultaDTO multaDTO) {
        Multa multa = multaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Multa não encontrado com ID: " + id));

        Carro carro = carroRepository.findById(multaDTO.getIdCarro())
        .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado com ID: " ));

        double pontuacaoAtual = carro.getPontuacao();
        double pontosAntigos = multa.getPontos();
        double pontosNovos = multaDTO.getPontos();

        double novaPontuacao = pontuacaoAtual - pontosAntigos + pontosNovos;
        carro.setPontuacao(novaPontuacao);

        multa.setPontos(pontosNovos);
        multa.setCarro(carro);

        multa = multaRepository.save(multa);
        carro = carroRepository.save(carro);
        return new MultaDTO(multa);
    }

    // Remover carro
   public void delete(Long id) {
    Multa multa = multaRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Multa não encontrada com ID: " + id));

    Carro carro = multa.getCarro();

    double novaPontuacao = carro.getPontuacao() - multa.getPontos();
    carro.setPontuacao(novaPontuacao);

    multaRepository.deleteById(id);
    carro = carroRepository.save(carro);
}

}
