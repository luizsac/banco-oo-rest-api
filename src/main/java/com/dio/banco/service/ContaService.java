package com.dio.banco.service;

import com.dio.banco.dto.ContaDTO;
import com.dio.banco.dto.NovaContaDTO;
import com.dio.banco.exception.*;

import java.math.BigDecimal;
import java.util.List;

public interface ContaService {

    ContaDTO salvar(NovaContaDTO novaContaDTO) throws ContaJaRegistradaException, AgenciaNaoEncontradaException, ClienteNaoEncontradoException;
    ContaDTO buscar(Long id) throws ContaNaoEncontradaException;
    List<ContaDTO> buscarTodas();
    BigDecimal sacar(Long id, BigDecimal valor) throws ContaNaoEncontradaException, SaldoIndisponivelException;
    BigDecimal depositar(Long id, BigDecimal valor) throws ContaNaoEncontradaException;
    BigDecimal transferir(Long id, BigDecimal valor, Long outroId) throws ContaNaoEncontradaException, SaldoIndisponivelException;
}
