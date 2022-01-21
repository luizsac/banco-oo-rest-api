package com.dio.banco.service;

import com.dio.banco.dto.ClienteDTO;
import com.dio.banco.dto.NovoClienteDTO;
import com.dio.banco.exception.ClienteJaRegistradoException;
import com.dio.banco.exception.ClienteNaoEncontradoException;

import java.util.List;

public interface ClienteService {

    ClienteDTO salvar(NovoClienteDTO novoClienteDTO) throws ClienteJaRegistradoException;
    ClienteDTO buscarPorId(Long id) throws ClienteNaoEncontradoException;
    List<ClienteDTO> buscarTodos();

}
