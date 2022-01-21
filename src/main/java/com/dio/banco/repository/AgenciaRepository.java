package com.dio.banco.repository;

import com.dio.banco.dto.AgenciaDTO;
import com.dio.banco.entity.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

    List<AgenciaDTO> findByNumero(Integer numero);

}
