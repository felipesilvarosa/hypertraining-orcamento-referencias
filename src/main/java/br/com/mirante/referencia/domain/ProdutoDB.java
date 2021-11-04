package br.com.mirante.referencia.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class ProdutoDB implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String codigo;
    private String descricao;

    @Column(name = "unidade_medida")
    private String unidadeMedida;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    List<Referencia> referencias;

    public ProdutoDB(String codigo, String descricao, String unidadeMedida) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
    }

    public ProdutoDB() {

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

    public List<Referencia> getReferencias() {
        return referencias;
    }

    public void setReferencias(List<Referencia> referencias) {
        this.referencias = referencias;
    }
}
