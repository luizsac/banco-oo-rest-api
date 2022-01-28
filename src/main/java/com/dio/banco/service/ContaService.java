package com.dio.banco.service;

import com.dio.banco.dto.ContaDTO;
import com.dio.banco.dto.NovaContaDTO;
import com.dio.banco.exception.AgenciaNaoEncontradaException;
import com.dio.banco.exception.ClienteNaoEncontradoException;
import com.dio.banco.exception.ContaJaRegistradaException;
import com.dio.banco.exception.ContaNaoEncontradaException;

import java.util.List;

public interface ContaService {

    ContaDTO salvar(NovaContaDTO novaContaDTO) throws ContaJaRegistradaException, AgenciaNaoEncontradaException, ClienteNaoEncontradoException;
    ContaDTO buscarPorId(Long id) throws ContaNaoEncontradaException;
    List<ContaDTO> buscarTodas();

}
