package com.servico.backservico.controller;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servico")
public class ServicoCantroller {

    private ServicoService servicoService;
    public ServicoCantroller(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping("/")
    public List<Servico> buscarTodos(){
        return servicoService.buscarTodos();
    }
    @GetMapping("/pagamentoPendente")
    public List<Servico> buscarServicosPagamentoPendente(){
        return servicoService.buscarServicosPagamentoPendente();
    }
    @GetMapping("/cancelados")
    public List<Servico> buscarServicoCancelado(){
        return servicoService.buscarServicosCancelados();
    }
    @PostMapping("/")
    public Servico inserir(@RequestBody Servico servico){
        return servicoService.inserir(servico);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable("id") Long id){
        servicoService.cancelarServico(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/")
    public Servico alterar(@RequestBody Servico servico){
        return servicoService.alterar(servico);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        servicoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
