package br.com.mirante.referencia.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "item")
public class ItemReferencia implements Serializable{

    @Id
    private String codigo;
    private String descricao;
    private String origem;

    @Column(name ="unidade_medida")
    private String unidadeMedida;

    @OneToMany(mappedBy = "item", orphanRemoval = true, cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Periodo> periodos;


    public ItemReferencia(String codigo, String descricao, String origem, String unidadeMedida) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.origem = origem;
        this.unidadeMedida = unidadeMedida;
    }

    protected ItemReferencia(){}

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }
}
