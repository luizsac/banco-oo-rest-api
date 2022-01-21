package com.dio.banco.service;

import com.dio.banco.dto.AgenciaDTO;
import com.dio.banco.dto.NovaAgenciaDTO;
import com.dio.banco.exception.AgenciaJaRegistradaException;
import com.dio.banco.exception.AgenciaNaoEncontradaException;
import com.dio.banco.exception.BancoNaoEncontradoException;

import java.util.List;

public interface AgenciaService {

    AgenciaDTO salvar(NovaAgenciaDTO novaAgenciaDTO) throws AgenciaJaRegistradaException, BancoNaoEncontradoException;
    AgenciaDTO buscarPorId(Long id) throws AgenciaNaoEncontradaException;
    List<AgenciaDTO> buscarTodas();
}
