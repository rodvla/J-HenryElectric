package com.henry.receptor.base.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@NoArgsConstructor
@Entity

public class Domicilio{

    @Id
    private Integer id;
    private Float tarifa;

    @OneToOne(fetch = FetchType.EAGER) //todo el contenido, contrario LAZY
    @JoinColumn(name = "medidorr_id")
    private MedidorR medidor;

    @OneToOne(fetch = FetchType.EAGER) //todo el contenido, contrario LAZY
    @JoinColumn(name = "client_id")
    private Cliente cliente;

}
