package com.cefet.prova_20223004358.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.prova_20223004358.entities.Carro;
import java.util.List;



public interface CarroRepository extends JpaRepository <Carro,Long> {
    List<Carro> findByPessoaId(Long pessoaid);
    
}
