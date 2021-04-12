package com.henry.receptor.base.controller;

import com.henry.receptor.base.model.MedidaR;
import com.henry.receptor.base.model.MedidorR;
import com.henry.receptor.base.service.MedidorService;
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
    public List<MedidorR> getMedidores(){
        return medidorService.getMedidores();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta medidor por id")
    public MedidorR getMedidor(@PathVariable Integer id) {
        return medidorService.getMedidor(id);
    }

    @PostMapping
    @Operation(summary = "Dar de alta un medidor")
    public String addMedidor(@RequestBody MedidorR medidor) {
        MedidorR postMedidor = medidorService.addMedidor(medidor);
        return ("Medidor creado: " + postMedidor);
    }

    @PostMapping("/{idMedidor}/medida")
    @Operation(summary = "Guardar una medida por id medidor")
    public String addMedida(@RequestBody MedidaR medida, @PathVariable Integer idMedidor) {
        medidorService.addMedidaToMedidor(idMedidor, medida);
        return ("Medida agregada");
    }

    @PutMapping
    @Operation(summary = "Editar medidor")
    public String editMedidor(@RequestBody MedidorR medidor){
        MedidorR putMedidor = medidorService.editMedidor(medidor);
        return ("Medidor Editado: " + putMedidor);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar medidor por id")
    public String deleteMedidor(@PathVariable Integer id){
        medidorService.deleteMedidorByid(id);
        return ("Medidor Borrado con id: " + id);
    }

}
