package br.com.mirante.referencia.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Periodo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mes;
    private String ano;
    private Float valor;

    @ManyToOne
    @JoinColumn(name = "codigo_fk", nullable = false)
    @JsonBackReference
    private ItemReferencia item;

    public Periodo(String mes, String ano, Float valor) {
        this.mes = mes;
        this.ano = ano;
        this.valor = valor;
    }

    protected Periodo(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public ItemReferencia getItem() {
        return item;
    }

    public void setItem(ItemReferencia item) {
        this.item = item;
    }


}
