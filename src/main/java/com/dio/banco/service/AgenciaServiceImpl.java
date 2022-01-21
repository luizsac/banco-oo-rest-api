package com.dio.banco.service;

import com.dio.banco.dto.AgenciaDTO;
import com.dio.banco.dto.NovaAgenciaDTO;
import com.dio.banco.entity.Agencia;
import com.dio.banco.exception.AgenciaJaRegistradaException;
import com.dio.banco.exception.AgenciaNaoEncontradaException;
import com.dio.banco.exception.BancoNaoEncontradoException;
import com.dio.banco.repository.AgenciaRepository;
import com.dio.banco.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgenciaServiceImpl implements AgenciaService {

    private final AgenciaRepository agenciaRepository;
    private final BancoRepository bancoRepository;
    private final ModelMapper modelMapper;

    @Override
    public AgenciaDTO salvar(NovaAgenciaDTO novaAgenciaDTO)
            throws AgenciaJaRegistradaException, BancoNaoEncontradoException {
        // verifica se já não existe agencia do mesmo banco com o mesmo número
        List<AgenciaDTO> agencias = agenciaRepository.findByNumero(novaAgenciaDTO.getNumero());
        for (AgenciaDTO agencia : agencias) {
            if (agencia.getBanco().getCodigo().equals(novaAgenciaDTO.getBanco().getCodigo())) {
                throw new AgenciaJaRegistradaException();
            }
        }

        novaAgenciaDTO.setBanco(
                bancoRepository.findByCodigo(novaAgenciaDTO.getBanco().getCodigo())
                        .orElseThrow(BancoNaoEncontradoException::new)
        );

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
