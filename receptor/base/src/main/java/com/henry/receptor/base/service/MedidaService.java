package com.henry.receptor.base.service;

import com.henry.receptor.base.model.MedidaR;
import com.henry.receptor.base.repository.MedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class MedidaService {

    @Autowired
    private MedidaRepository medidaRepository;

    public List<MedidaR> getMedidas() {
        return medidaRepository.findAll();
    }

    public MedidaR getMedida(Integer id) {
        return medidaRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public MedidaR addMedida(MedidaR medida) {
        return medidaRepository.save(medida);
    }
}