package br.com.mirante.referencia.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
public class Referencia implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer mes;
    private Integer ano;
    private String origem;
    private Float valor;

    @ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    @JoinColumn(name="id_produto")
    @JsonBackReference
    private ProdutoDB produto;

    public Referencia(Integer mes, Integer ano, String origem, Float valor) {
        this.mes = mes;
        this.ano = ano;
        this.origem = origem;
        this.valor = valor;
    }


    public Referencia() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public ProdutoDB getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDB produto) {
        this.produto = produto;
    }
}
