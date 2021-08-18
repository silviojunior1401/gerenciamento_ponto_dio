package com.dio.live.service;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaUsuario saveCategoria(CategoriaUsuario categoriaUsuario){
        return categoriaRepository.save(categoriaUsuario);
    }

    public List<CategoriaUsuario> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<CategoriaUsuario> getById(Long idCategoria) {
        return categoriaRepository.findById(idCategoria);
    }

    public CategoriaUsuario updateCategoria(CategoriaUsuario categoriaUsuario){
        return categoriaRepository.save(categoriaUsuario);
    }

    public void deleteCategoria(Long idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
}
