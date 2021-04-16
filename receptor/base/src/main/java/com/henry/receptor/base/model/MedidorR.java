package com.henry.receptor.base.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class MedidorR {

    @Id
    private Integer id;
    private String marca;
    private String modelo;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<MedidaR> medidas;
}
