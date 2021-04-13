package com.henry.receptor.base.controller;

import com.henry.receptor.base.model.Cliente;
import com.henry.receptor.base.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Lista de clientes")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }


    @GetMapping("/{id}")
    @Operation(summary = "Consulta cliente por id")
    public Cliente getCliente(@PathVariable Integer id) {
        return clienteService.getCliente(id);
    }


    @PostMapping
    @Operation(summary = "Dar de alta un cliente")
    public String addCliente(@RequestBody Cliente cliente) {
        Cliente postcliente = clienteService.addCliente(cliente);
        return ("Cliente creado: " + postcliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar cliente por id")
    public String deleteWrite(@PathVariable Integer id){
        clienteService.deleteClienteByid(id);
        return ("Cliente Borrado con id: " + id);
    }

}
