package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.service.CategoriaService;
import com.dio.live.service.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriausuario")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public CategoriaUsuario createCategoria(@RequestBody CategoriaUsuario categoriausuario){
        return categoriaService.saveCategoria(categoriausuario);
    }

    @GetMapping
    public List<CategoriaUsuario> getCategoriaList(){
        return categoriaService.findAll();
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<CategoriaUsuario> getCategoriaByID(@PathVariable("idCategoria") Long idCategoria) throws Exception {
        //return ResponseEntity.ok(categoriaService.getById(idCategoria).orElseThrow(() -> new NoSuchElementException("Not found!")));
        return ResponseEntity.ok(categoriaService.getById(idCategoria).orElse(new CategoriaUsuario()));
    }

    @PutMapping
    public CategoriaUsuario updateCategoria(@RequestBody CategoriaUsuario categoriausuario){
        return categoriaService.updateCategoria(categoriausuario);
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<Resposta> deleteByID(@PathVariable("idCategoria") Long idCategoria) throws Exception {
        try {
            categoriaService.deleteCategoria(idCategoria);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ResponseEntity.internalServerError();
        }
        return ResponseEntity.ok(new Resposta("Id " + idCategoria + " Excluído com Sucesso"));
    }
}
