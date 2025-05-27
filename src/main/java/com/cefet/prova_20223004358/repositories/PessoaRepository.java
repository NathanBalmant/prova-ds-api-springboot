package com.cefet.prova_20223004358.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.prova_20223004358.entities.Pessoa;



public interface PessoaRepository extends JpaRepository <Pessoa,Long>{
    Pessoa findByCpf(String cpf);

}
