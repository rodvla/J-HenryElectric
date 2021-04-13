package com.henry.receptor.base.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Factura {

    private String direccion;
    private Float tarifa;
    private Cliente cliente;
    private Integer numeroMedidor;
    private Float medicionInicial;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date fechaMedidaInicial;
    private Float medicionFinal;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date fechaMedidaFinal;
    private Float consumoKwh;
    private Float costoTotal;

}