package com.dio.banco.service;

import com.dio.banco.dto.AgenciaDTO;
import com.dio.banco.dto.NovaAgenciaDTO;
import com.dio.banco.entity.Agencia;
import com.dio.banco.exception.AgenciaJaRegistradaException;
import com.dio.banco.exception.AgenciaNaoEncontradaException;
import com.dio.banco.repository.AgenciaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgenciaServiceImpl implements AgenciaService {

    private final AgenciaRepository agenciaRepository;
    private final ModelMapper modelMapper;

    @Override
    public AgenciaDTO salvar(NovaAgenciaDTO novaAgenciaDTO)
            throws AgenciaJaRegistradaException {
        if (agenciaRepository.findByNumero(novaAgenciaDTO.getNumero()).isPresent()) {
            throw new AgenciaJaRegistradaException();
        }

        var agenciaSalva = agenciaRepository.save(modelMapper.map(novaAgenciaDTO, Agencia.class));
        return modelMapper.map(agenciaSalva, AgenciaDTO.class);
    }

    @Override
    public AgenciaDTO buscarPorId(Long id) throws AgenciaNaoEncontradaException {
        var agenciaOptional = agenciaRepository.findById(id);
        return modelMapper.map(agenciaOptional.orElseThrow(AgenciaNaoEncontradaException::new), AgenciaDTO.class);
    }

    @Override
    public List<AgenciaDTO> buscarTodas() {
        var agencias = agenciaRepository.findAll();
        return agencias
                .stream()
                .map(agencia -> modelMapper.map(agencia, AgenciaDTO.class))
                .collect(Collectors.toList());
    }

}
