package com.henry.medidor.base.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Medidor {

    @Id
    private Integer id;
    private Integer number;
    @ElementCollection
    private List<Medida> medidas;

}
