package com.dio.banco.service;

import com.dio.banco.dto.AgenciaDTO;
import com.dio.banco.dto.NovaAgenciaDTO;
import com.dio.banco.exception.AgenciaJaRegistradaException;
import com.dio.banco.exception.AgenciaNaoEncontradaException;

import java.util.List;

public interface AgenciaService {

    AgenciaDTO salvar(NovaAgenciaDTO novaAgenciaDTO) throws AgenciaJaRegistradaException;
    AgenciaDTO buscarPorId(Long id) throws AgenciaNaoEncontradaException;
    List<AgenciaDTO> buscarTodas();
}
