package com.dio.banco.resource;

import com.dio.banco.dto.ContaDTO;
import com.dio.banco.dto.NovaContaDTO;
import com.dio.banco.exception.*;
import com.dio.banco.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService contaService;

    @PostMapping
    public ResponseEntity<ContaDTO> salvar(@RequestBody NovaContaDTO novaContaDTO)
            throws ContaJaRegistradaException, AgenciaNaoEncontradaException, ClienteNaoEncontradoException {
        var contaDTO = contaService.salvar(novaContaDTO);
        return new ResponseEntity<>(contaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaDTO> buscar(@PathVariable Long id) throws ContaNaoEncontradaException {
        return new ResponseEntity<>(contaService.buscar(id), HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ContaDTO>> listar() {
        return new ResponseEntity<>(contaService.buscarTodas(), HttpStatus.OK);
    }

    @PatchMapping("/{id}/sacar")
    public ResponseEntity<BigDecimal> sacar(@PathVariable Long id, @RequestBody BigDecimal valor)
            throws SaldoIndisponivelException, ContaNaoEncontradaException {
        return new ResponseEntity<>(contaService.sacar(id, valor), HttpStatus.OK);
    }

    @PatchMapping("/id/depositar")
    public ResponseEntity<BigDecimal> depositar(@PathVariable Long id, @RequestBody BigDecimal valor)
            throws ContaNaoEncontradaException {
        return new ResponseEntity<>(contaService.depositar(id, valor), HttpStatus.OK);
    }

    @PatchMapping("/{id}/transferir")
    public ResponseEntity<BigDecimal> transferir(
            @PathVariable Long id, @RequestBody BigDecimal valor, @RequestBody Long outroId)
            throws ContaNaoEncontradaException, SaldoIndisponivelException {
        return new ResponseEntity<>(contaService.transferir(id, valor, outroId), HttpStatus.OK);
    }

}
