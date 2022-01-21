package com.dio.banco.service;

import com.dio.banco.dto.BancoDTO;
import com.dio.banco.dto.NovoBancoDTO;
import com.dio.banco.entity.Banco;
import com.dio.banco.exception.BancoNaoEncontradoException;
import com.dio.banco.exception.BancoJaRegistradoException;
import com.dio.banco.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BancoServiceImpl implements BancoService {

    private final BancoRepository bancoRepository;
    private final ModelMapper modelMapper;

    @Override
    public BancoDTO salvar(NovoBancoDTO novoBancoDTO) throws BancoJaRegistradoException {
        if (bancoRepository.findByCodigo(novoBancoDTO.getCodigo()).isPresent()) {
            throw new BancoJaRegistradoException();
        }

        var bancoSalvo = bancoRepository.save(modelMapper.map(novoBancoDTO, Banco.class));
        return modelMapper.map(bancoSalvo, BancoDTO.class);
    }

    @Override
    public BancoDTO buscarPorId(Long id) throws BancoNaoEncontradoException {
        var bancoOptional = bancoRepository.findById(id);
        return modelMapper.map(bancoOptional.orElseThrow(BancoNaoEncontradoException::new), BancoDTO.class);
    }

    @Override
    public List<BancoDTO> buscarTodos() {
        var bancos = bancoRepository.findAll();
        return bancos
                .stream()
                .map(banco -> modelMapper.map(banco, BancoDTO.class))
                .collect(Collectors.toList());
    }

}
