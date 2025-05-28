package com.cefet.prova_20223004358.dto;

import com.cefet.prova_20223004358.entities.Carro;


public class CarroDTO {

    private Long id;
    private String placa;
    private String nomePessoa;
    private String cpfPessoa;
    private Double pontuacao;

    public CarroDTO() {

    }

    public CarroDTO(Carro carro) {
        this.id = carro.getId();
        this.placa = carro.getPlaca();
        this.nomePessoa = carro.getPessoa().getNome();
        this.cpfPessoa = carro.getPessoa().getCpf();
        this.pontuacao = carro.getPontuacao();

    }

    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public Double getPontuacao() {
        return pontuacao;
    }

  
    

    

}
