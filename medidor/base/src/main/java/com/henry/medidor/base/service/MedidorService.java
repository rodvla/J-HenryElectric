package com.henry.medidor.base.service;

import com.henry.medidor.base.model.Medidor;
import com.henry.medidor.base.repository.MedidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class MedidorService {

    @Autowired
    private MedidorRepository medidorRepository;

    public List<Medidor> getMedidores() {
        return medidorRepository.findAll();
    }

    public Medidor getMedidor(Integer id) {
        return medidorRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public Medidor addMedidor(Medidor medidor) {
        return medidorRepository.save(medidor);
    }

    public Medidor editMedidor(Medidor medido) {
        Medidor medidor = medidorRepository.findById(medido.getId()).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        Medidor editMedidor = new Medidor();
        editMedidor.setId(medidor.getId());
        if (medido.getNumber() != null) {
            editMedidor.setNumber(medido.getNumber());
        } else {
            editMedidor.setNumber(medidor.getNumber());
        }
        if (medido.getMedidas() != null) {
            editMedidor.setMedidas(medido.getMedidas());
        } else {
            editMedidor.setMedidas(medidor.getMedidas());
        }
        return medidorRepository.save(editMedidor);
    }

    public void deleteMedidorByid(Integer id) {
        medidorRepository.deleteById(id);
    }
}
