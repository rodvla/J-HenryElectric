package com.henry.medidor.base.service;

import com.henry.medidor.base.model.Medida;
import com.henry.medidor.base.repository.MedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class MedidaService {

    @Autowired
    private MedidaRepository medidaRepository;

    public List<Medida> getMedidas() {
        return medidaRepository.findAll();
    }

    public Medida getMedida(Integer id) {
        return medidaRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public Medida addMedida(Medida medida) {
        return medidaRepository.save(medida);
    }
}