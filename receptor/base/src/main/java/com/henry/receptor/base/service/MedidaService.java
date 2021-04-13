package com.henry.receptor.base.service;

import com.henry.receptor.base.model.BodyFechas;
import com.henry.receptor.base.model.Consumo;
import com.henry.receptor.base.model.MedidaR;
import com.henry.receptor.base.repository.MedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MedidaService {

    @Autowired
    private MedidaRepository medidaRepository;

    public List<MedidaR> getMedidasByDate(Integer idMedidor, BodyFechas bodyFechas) {
        List<MedidaR> lista = medidaRepository.findByDateBetween(idMedidor, bodyFechas.getFrom(), bodyFechas.getTo());
        return lista;
    }

    public List<MedidaR> getMedidas(){
        return medidaRepository.findAll();
    }

    public MedidaR getMedida(Integer id) {
        return medidaRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public MedidaR addMedida(MedidaR medida) {
        return medidaRepository.save(medida);
    }

    public Consumo getConsumoByDate(Integer idMedidor, BodyFechas bodyFechas, Float tarifa) {

        List<MedidaR> lista1 = medidaRepository.findByDateBetween(idMedidor, bodyFechas.getFrom(), bodyFechas.getFrom() + " 23:59:59.999");
        List<MedidaR> lista2 = medidaRepository.findByDateBetween(idMedidor, bodyFechas.getTo(), bodyFechas.getTo() + " 23:59:59.999");
        System.out.println(lista1);
        System.out.println(lista2);
        Float consumo = lista2.get(lista2.size()-1).getValor() - lista1.get(0).getValor();
        Float costo = consumo * tarifa;
        return new Consumo(consumo,costo);

    }
}