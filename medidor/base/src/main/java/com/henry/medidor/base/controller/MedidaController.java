package com.henry.medidor.base.controller;

import com.henry.medidor.base.model.Medida;
import com.henry.medidor.base.service.MedidaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medida")
public class MedidaController {

    @Autowired
    private MedidaService medidaService;

    @GetMapping
    @Operation(summary = "Lista de medidas")
    public List<Medida> getMedidores(){
        return medidaService.getMedidas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta medida por id")
    public Medida getMedida(@PathVariable Integer id) {
        return medidaService.getMedida(id);
    }

    @PostMapping
    @Operation(summary = "Dar de alta un medida")
    public String addMedida(@RequestBody Medida medida) {
        Medida postMedida = medidaService.addMedida(medida);
        return ("Medidor creado: " + postMedida);
    }

}