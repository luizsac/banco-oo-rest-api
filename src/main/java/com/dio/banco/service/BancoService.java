package com.dio.banco.service;

import com.dio.banco.dto.BancoDTO;
import com.dio.banco.dto.NovoBancoDTO;
import com.dio.banco.exception.BancoJaRegistradoException;
import com.dio.banco.exception.BancoNaoEncontradoException;

import java.util.List;

public interface BancoService {

    BancoDTO salvar(NovoBancoDTO novoBancoDTO) throws BancoJaRegistradoException;
    BancoDTO buscarPorId(Long id) throws BancoNaoEncontradoException;
    List<BancoDTO> buscarTodos();
}
