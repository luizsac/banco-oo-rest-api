package com.dio.banco.repository;

import com.dio.banco.entity.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

    Optional<Agencia> findByNumero(Integer numero);

}
