package com.henry.receptor.base.controller;

import com.henry.receptor.base.model.*;
import com.henry.receptor.base.service.DomicilioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilio")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @PostMapping
    @Operation(summary = "Dar de alta un domicilio")
    public String addDomicilio(@RequestBody Domicilio domicilio) {
        Domicilio postdomicilio = domicilioService.addDomicilio(domicilio);
        return ("Domicilio Creado: " + postdomicilio);
    }

    @PutMapping("/{id}/cliente/{clienteID}")
    @Operation(summary = "Agregar cliente al domicilio")
    private String addCliente(@PathVariable Integer id, @PathVariable Integer clienteID) {
        domicilioService.addClienteToDomicilio(id, clienteID);
        return ("Agregado cliente con id: " + clienteID);
    }

    @PutMapping("/{id}/medidor/{medidorID}")
    @Operation(summary = "Agregar medidor al domicilio")
    private String addMedidor(@PathVariable Integer id, @PathVariable Integer medidorID) {
        domicilioService.addMedidorToDomicilio(id, medidorID);
        return ("Agregado medidor con id: " + medidorID);
    }

    @GetMapping
    @Operation(summary = "Lista de Domicilios")
    public List<Domicilio> getDomicilios() {
        return domicilioService.getDomicilios();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borra domicilio pasando id")
    public String deleteDomicilio(@PathVariable Integer id){
        domicilioService.deleteDomicilioByid(id);
        return ("Domicilio Borrado con id: " + id);
    }

    @GetMapping("/{id}/factura")
    @Operation(summary = "Factura Mensual")
    public Factura getFactura(@PathVariable Integer id, @RequestParam(value = "mes") String mes, @RequestParam(value = "año") String año) {
        return domicilioService.getFactura(id,mes,año);
    }

    @PostMapping("/{id}/medidas")
    @Operation(summary = "Lista de medidas entre fechas por Domicilio")
    public List<MedidaR> getMedidasBetweenDates(@PathVariable Integer id, @RequestBody BodyFechas bodyFechas){
        return domicilioService.getMedidasByDate(id, bodyFechas);
    }
    @PostMapping("/{id}/consumo")
    @Operation(summary = "Consumo entre fechas por Domicilio")
    public Consumo getConsumoBetweenDates(@PathVariable Integer id, @RequestBody BodyFechas bodyFechas){
        return domicilioService.getConsumoByDate(id, bodyFechas);
    }


}
