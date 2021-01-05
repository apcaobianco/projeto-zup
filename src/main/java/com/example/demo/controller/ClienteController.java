package com.example.demo.controller;

import com.example.demo.request.ClienteRequest;
import com.example.demo.error.ColetorErros;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RequestMapping({"/cliente"})
@RestController
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente novo(@Valid @RequestBody ClienteRequest clienteRequest, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos inválidos: " + new ColetorErros(result.getAllErrors()).getMensagemErro());
        }
        return clienteService.novo(clienteRequest.convert());
    }
}
