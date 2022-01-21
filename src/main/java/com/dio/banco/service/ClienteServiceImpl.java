package com.dio.banco.service;

import com.dio.banco.dto.ClienteDTO;
import com.dio.banco.dto.NovoClienteDTO;
import com.dio.banco.entity.Cliente;
import com.dio.banco.exception.ClienteJaRegistradoException;
import com.dio.banco.exception.ClienteNaoEncontradoException;
import com.dio.banco.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    @Override
    public ClienteDTO salvar(NovoClienteDTO novoClienteDTO) throws ClienteJaRegistradoException {
        if (clienteRepository.findByCpf(novoClienteDTO.getCpf()).isPresent()) {
            throw new ClienteJaRegistradoException();
        }

        var clienteSalvo = clienteRepository.save(modelMapper.map(novoClienteDTO, Cliente.class));
        return modelMapper.map(clienteSalvo, ClienteDTO.class);
    }

    @Override
    public ClienteDTO buscarPorId(Long id) throws ClienteNaoEncontradoException {
        var clienteOptional = clienteRepository.findById(id);
        return modelMapper.map(clienteOptional.orElseThrow(ClienteNaoEncontradoException::new), ClienteDTO.class);
    }

    @Override
    public List<ClienteDTO> buscarTodos() {
        var clientes = clienteRepository.findAll();
        return clientes
                .stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

}
