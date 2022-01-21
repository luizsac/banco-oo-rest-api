package com.dio.banco.resource;

import com.dio.banco.dto.AgenciaDTO;
import com.dio.banco.dto.NovaAgenciaDTO;
import com.dio.banco.exception.AgenciaJaRegistradaException;
import com.dio.banco.exception.AgenciaNaoEncontradaException;
import com.dio.banco.exception.BancoNaoEncontradoException;
import com.dio.banco.service.AgenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agencia")
@RequiredArgsConstructor
public class AgenciaController {

    private final AgenciaService agenciaService;

    @PostMapping
    public ResponseEntity<AgenciaDTO> salvar(@RequestBody NovaAgenciaDTO novaAgenciaDTO)
            throws AgenciaJaRegistradaException, BancoNaoEncontradoException {
        var agenciaDTO = agenciaService.salvar(novaAgenciaDTO);
        return new ResponseEntity<>(agenciaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenciaDTO> buscar(@PathVariable Long id) throws AgenciaNaoEncontradaException {
        return new ResponseEntity<>(agenciaService.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<AgenciaDTO>> listar() {
        return new ResponseEntity<>(agenciaService.buscarTodas(), HttpStatus.OK);
    }

}
