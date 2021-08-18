package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.service.BancoHorasService;
import com.dio.live.service.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bancohoras")
public class BancoHorasController {
    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.saveBancoHoras(bancoHoras);
    }

    @GetMapping
    public List<BancoHoras> getBancoHorasList(){
        return bancoHorasService.findAll();
    }

    @GetMapping("/{idBancoHoras}/{idMovimentacao}/{idUsuario}/")
    public ResponseEntity<BancoHoras> getBancoHorasByID(
            @PathVariable("idBancoHoras") Long idBancoHoras,
            @PathVariable("idMovimentacao") Long idMovimentacao,
            @PathVariable("idUsuario") Long idUsuario) throws Exception {
        //return ResponseEntity.ok(bancoHorasService.getById(idBanco).orElseThrow(() -> new NoSuchElementException("Not found!")));
        return ResponseEntity.ok(bancoHorasService.getById(idBancoHoras,idMovimentacao,idUsuario).orElse(new BancoHoras()));
    }

    @PutMapping
    public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.updateBancoHoras(bancoHoras);
    }

    @DeleteMapping("/{idBancoHoras}/{idMovimentacao}/{idUsuario}/")
    public ResponseEntity<Resposta> deleteByID(
            @PathVariable("idBancoHoras") Long idBancoHoras,
            @PathVariable("idMovimentacao") Long idMovimentacao,
            @PathVariable("idUsuario") Long idUsuario) throws Exception {
        try {
            bancoHorasService.deleteBancoHoras(idBancoHoras,idMovimentacao,idUsuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ResponseEntity.internalServerError();
        }
        return ResponseEntity.ok(new Resposta("Id " + idBancoHoras + " Excluído com Sucesso"));
    }
}
