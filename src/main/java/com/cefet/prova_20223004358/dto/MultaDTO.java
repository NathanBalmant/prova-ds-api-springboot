package com.cefet.prova_20223004358.dto;

import com.cefet.prova_20223004358.entities.Multa;

public class MultaDTO {

    private Long id;
    private Double pontos;
    private Long idCarro;
    private String placaCarro;

    public MultaDTO() {

    }

    public MultaDTO(Multa multa){
        this.id = multa.getId();
        this.pontos = multa.getPontos();
        this.idCarro = multa.getCarro().getId();
        this.placaCarro = multa.getCarro().getPlaca();

    }

    public Long getId() {
        return id;
    }

    public Double getPontos() {
        return pontos;
    }

    public Long getIdCarro() {
        return idCarro;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    

}
