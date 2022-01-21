package com.dio.banco.repository;

import com.dio.banco.entity.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BancoRepository extends JpaRepository<Banco, Long> {

    Optional<Banco> findByCodigo(Integer codigo);

}
