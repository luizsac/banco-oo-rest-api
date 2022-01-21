package com.dio.banco.resource;

import com.dio.banco.dto.BancoDTO;
import com.dio.banco.dto.NovoBancoDTO;
import com.dio.banco.exception.BancoJaRegistradoException;
import com.dio.banco.exception.BancoNaoEncontradoException;
import com.dio.banco.service.BancoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco")
@RequiredArgsConstructor
public class BancoController {

    private final BancoServiceImpl bancoService;

    @PostMapping
    public ResponseEntity<BancoDTO> salvar(@RequestBody NovoBancoDTO novoBancoDTO) throws BancoJaRegistradoException {
        var bancoDTO = bancoService.salvar(novoBancoDTO);
        return new ResponseEntity<>(bancoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancoDTO> buscar(@PathVariable Long id) throws BancoNaoEncontradoException {
        return new ResponseEntity<>(bancoService.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping("lista")
    public ResponseEntity<List<BancoDTO>> listar() {
        return new ResponseEntity<>(bancoService.buscarTodos(), HttpStatus.OK);
    }

}
