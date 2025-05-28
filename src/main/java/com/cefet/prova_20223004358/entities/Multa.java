package com.cefet.prova_20223004358.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_multas")
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private Double pontos;


    @ManyToOne
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;


    public Multa(){

    }


    public Multa(Long id, Double pontos, Carro carro) {
        this.id = id;
        this.pontos = pontos;
        this.carro = carro;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Double getPontos() {
        return pontos;
    }


    public void setPontos(Double pontos) {
        this.pontos = pontos;
    }


    public Carro getCarro() {
        return carro;
    }


    public void setCarro(Carro carro) {
        this.carro = carro;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Multa other = (Multa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
