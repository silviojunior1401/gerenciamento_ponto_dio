package com.dio.live.repository;

import com.dio.live.model.BancoHoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, BancoHoras.BancoHorasId>  {
    /*Optional<BancoHoras> findByIdBancoHorasAndIdMovimentacaoAndidUsuario(Long idBancoHoras, Long idMovimentacao, Long idUsuario);
    void deleteByIdBancoHorasAndIdMovimentacaoAndidUsuario(Long idBancoHoras, Long idMovimentacao, Long idUsuario);*/
}
