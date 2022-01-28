package com.dio.banco.repository;

import com.dio.banco.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> getByNumero(Long numero);

}
