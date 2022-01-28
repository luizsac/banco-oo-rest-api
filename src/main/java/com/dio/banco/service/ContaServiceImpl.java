package com.dio.banco.service;

import com.dio.banco.dto.ContaDTO;
import com.dio.banco.dto.NovaContaDTO;
import com.dio.banco.entity.Conta;
import com.dio.banco.entity.ContaCorrente;
import com.dio.banco.entity.ContaPoupanca;
import com.dio.banco.exception.AgenciaNaoEncontradaException;
import com.dio.banco.exception.ClienteNaoEncontradoException;
import com.dio.banco.exception.ContaJaRegistradaException;
import com.dio.banco.exception.ContaNaoEncontradaException;
import com.dio.banco.repository.AgenciaRepository;
import com.dio.banco.repository.ClienteRepository;
import com.dio.banco.repository.ContaRepository;
import com.dio.banco.type.TipoConta;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContaServiceImpl implements ContaService {

    private final AgenciaRepository agenciaRepository;
    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository;
    private final ModelMapper modelMapper;

    @Override
    public ContaDTO salvar(NovaContaDTO novaContaDTO)
            throws ContaJaRegistradaException, AgenciaNaoEncontradaException, ClienteNaoEncontradoException {
        if(contaRepository.getByNumero(novaContaDTO.getNumero()).isPresent()) {
            throw new ContaJaRegistradaException();
        }

        Conta novaConta;
        if (novaContaDTO.getTipoConta() == TipoConta.CONTA_CORRENTE) {
            novaConta = modelMapper.map(novaContaDTO, ContaCorrente.class);
        } else {
            novaConta = modelMapper.map(novaContaDTO, ContaPoupanca.class);
        }

        novaConta.setAgencia(agenciaRepository.findById(novaContaDTO.getAgenciaId()).
                orElseThrow(AgenciaNaoEncontradaException::new));
        novaConta.setCliente(clienteRepository.findById(novaContaDTO.getClienteId()).
                orElseThrow(ClienteNaoEncontradoException::new));
        novaConta.setSaldo(BigDecimal.ZERO);
        var contaSalva = contaRepository.save(novaConta);
        return modelMapper.map(contaSalva, ContaDTO.class);
    }

    @Override
    public ContaDTO buscarPorId(Long id) throws ContaNaoEncontradaException {
        var contaOptional = contaRepository.findById(id);
        return modelMapper.map(contaOptional.orElseThrow(ContaNaoEncontradaException::new), ContaDTO.class);
    }

    @Override
    public List<ContaDTO> buscarTodas() {
        var contas = contaRepository.findAll();
        return contas
                .stream()
                .map(conta -> modelMapper.map(conta, ContaDTO.class))
                .collect(Collectors.toList());
    }

}
