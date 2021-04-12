package com.henry.medidor.base.controller;

import com.henry.medidor.base.model.Medidor;
import com.henry.medidor.base.service.MedidorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medidor")
public class MedidorController {

    @Autowired
    private MedidorService medidorService;

    @GetMapping
    @Operation(summary = "Lista de medidores")
    public List<Medidor> getMedidores(){
        return medidorService.getMedidores();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta medidor por id")
    public Medidor getMedidor(@PathVariable Integer id) {
        return medidorService.getMedidor(id);
    }

    @PostMapping
    @Operation(summary = "Dar de alta un medidor")
    public String addMedidor(@RequestBody Medidor medidor) {
        Medidor postMedidor = medidorService.addMedidor(medidor);
        return ("Medidor creado: " + postMedidor);
    }

    @PutMapping
    @Operation(summary = "Editar medidor")
    public String editMedidor(@RequestBody Medidor medidor){
        Medidor putMedidor = medidorService.editMedidor(medidor);
        return ("Medidor Editado: " + putMedidor);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar medidor por id")
    public String deleteMedidor(@PathVariable Integer id){
        medidorService.deleteMedidorByid(id);
        return ("Medidor Borrado con id: " + id);
    }

}
