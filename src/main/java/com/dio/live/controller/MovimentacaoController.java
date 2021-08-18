package com.dio.live.controller;

import com.dio.live.model.Movimentacao;
import com.dio.live.service.MovimentacaoService;
import com.dio.live.service.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao createMovimentacao(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.saveMovimentacao(movimentacao);
    }

    @GetMapping
    public List<Movimentacao> getMovimentacaoList(){
        return movimentacaoService.findAll();
    }

    @GetMapping("/{idMovimentacao}/{idUsuario}/")
    public ResponseEntity<Movimentacao> getMovimentacaoByID(
            @PathVariable("idMovimentacao") Long idMovimentacao,
            @PathVariable("idUsuario") Long idUsuario) throws Exception {
        //return ResponseEntity.ok(movimentacaoService.getById(idBanco).orElseThrow(() -> new NoSuchElementException("Not found!")));
        return ResponseEntity.ok(movimentacaoService.getById(idMovimentacao,idUsuario).orElse(new Movimentacao()));
    }

    @PutMapping
    public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.updateMovimentacao(movimentacao);
    }

    @DeleteMapping("/{idMovimentacao}/{idUsuario}/")
    public ResponseEntity<Resposta> deleteByID(
            @PathVariable("idMovimentacao") Long idMovimentacao,
            @PathVariable("idUsuario") Long idUsuario) throws Exception {
        try {
            movimentacaoService.deleteMovimentacao(idMovimentacao,idUsuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ResponseEntity.internalServerError();
        }
        return ResponseEntity.ok(new Resposta("Id " + idMovimentacao + " Excluído com Sucesso"));
    }
}
