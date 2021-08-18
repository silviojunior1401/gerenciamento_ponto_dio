package com.dio.live.service;

import com.dio.live.model.BancoHoras;
import com.dio.live.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {
    BancoHorasRepository bancoHorasRepository;

    @Autowired
    public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    public BancoHoras saveBancoHoras(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> findAll() {
        return bancoHorasRepository.findAll();
    }

    public Optional<BancoHoras> getById(Long idBancoHoras, Long idMovimentacao, Long idUsuario) {
        //return bancoHorasRepository.findByIdBancoHorasAndIdMovimentacaoAndidUsuario(idBancoHoras, idMovimentacao, idUsuario);
        var idBanco = new BancoHoras.BancoHorasId(idBancoHoras, idMovimentacao, idUsuario);
        return bancoHorasRepository.findById(idBanco);
    }

    public BancoHoras updateBancoHoras(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public void deleteBancoHoras(Long idBancoHoras, Long idMovimentacao, Long idUsuario) {
        var idBanco = new BancoHoras.BancoHorasId(idBancoHoras, idMovimentacao, idUsuario);
        bancoHorasRepository.deleteById(idBanco);
    }

}
