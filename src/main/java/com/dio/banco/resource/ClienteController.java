package com.dio.banco.resource;

import com.dio.banco.dto.ClienteDTO;
import com.dio.banco.dto.NovoClienteDTO;
import com.dio.banco.exception.ClienteJaRegistradoException;
import com.dio.banco.exception.ClienteNaoEncontradoException;
import com.dio.banco.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@RequestBody NovoClienteDTO novoClienteDTO)
            throws ClienteJaRegistradoException {
        var clienteDTO = clienteService.salvar(novoClienteDTO);
        return new ResponseEntity<>(clienteDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscar(@PathVariable Long id) throws ClienteNaoEncontradoException {
        return new ResponseEntity<>(clienteService.buscarPorId(id), HttpStatus.OK);
    }

    public ResponseEntity<List<ClienteDTO>> listar() {
        return new ResponseEntity<>(clienteService.buscarTodos(), HttpStatus.OK);
    }

}
