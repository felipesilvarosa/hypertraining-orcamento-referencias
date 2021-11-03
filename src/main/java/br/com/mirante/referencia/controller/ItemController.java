package br.com.mirante.referencia.controller;

import br.com.mirante.referencia.domain.ItemReferencia;
import br.com.mirante.referencia.domain.Periodo;
import br.com.mirante.referencia.service.CadastrarItemReferenciaServico;
import br.com.mirante.referencia.service.ExcluirItemServico;
import br.com.mirante.referencia.service.ListarItensServico;
import br.com.mirante.referencia.service.ListarPeriodosServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private CadastrarItemReferenciaServico cadastrarItemServico;

    @Autowired
    private ExcluirItemServico excluirServico;

    @Autowired
    private ListarItensServico listarServico;

    @Autowired
    private ListarPeriodosServico listarPeriodoServico;

    @GetMapping
    public List<ItemReferencia> listarItens(){
        return listarServico.listarItens();
    }

    @PostMapping
    public void cadastrarItem(@RequestBody CadastrarItemRequest request){
        cadastrarItemServico.cadastrar(request.item, request.periodos);
    }

    @DeleteMapping("/{codigo}")
    public void excluirItem(@PathVariable String codigo) {
        excluirServico.excluirItem(codigo);
    }

}

class CadastrarItemRequest{
    ItemReferencia item;
    List<Periodo> periodos;

    public ItemReferencia getItem() {
        return item;
    }

    public void setItem(ItemReferencia item) {
        this.item = item;
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }
}