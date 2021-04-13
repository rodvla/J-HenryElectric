package com.henry.medidor.base.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Medidor {

    @Id
    private Integer id;
    private String marca;
    private String modelo;

    @ElementCollection(fetch = FetchType.EAGER)
    public List<Medida> medidas;

}
