package com.henry.receptor.base.controller;

import com.henry.receptor.base.model.BodyFechas;
import com.henry.receptor.base.model.Consumo;
import com.henry.receptor.base.model.MedidaR;
import com.henry.receptor.base.service.MedidaService;
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
    public List<MedidaR> getMedidas(){
        return medidaService.getMedidas();
    }

    @PostMapping("/{idMedidor}/medidas")
    @Operation(summary = "Lista de medidas entre fechas")
    public List<MedidaR> getMedidasBetweenDates(@PathVariable Integer idMedidor, @RequestBody BodyFechas bodyFechas){
        return medidaService.getMedidasByDate(idMedidor, bodyFechas);
    }
    @PostMapping("/{idMedidor}/consumo/{tarifa}")
    @Operation(summary = "Consumo entre fechas")
    public Consumo getConsumoBetweenDates(@PathVariable Integer idMedidor, @PathVariable Float tarifa, @RequestBody BodyFechas bodyFechas){
        return medidaService.getConsumoByDate(idMedidor, bodyFechas, tarifa);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta medida por id")
    public MedidaR getMedida(@PathVariable Integer id) {
        return medidaService.getMedida(id);
    }

    @PostMapping
    @Operation(summary = "Dar de alta un medida")
    public String addMedida(@RequestBody MedidaR medida) {
        MedidaR postMedida = medidaService.addMedida(medida);
        return ("Medidor creado: " + postMedida);
    }

}
