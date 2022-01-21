package com.dio.banco.repository;

import com.dio.banco.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {



}
