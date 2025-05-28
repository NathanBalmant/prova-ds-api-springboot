package com.cefet.prova_20223004358.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cefet.prova_20223004358.entities.Multa;

public interface MultaRepository extends JpaRepository <Multa,Long>{
    List<Multa> findByCarroId(Long carroid);

}
