package com.henry.receptor.base.service;

import com.henry.receptor.base.model.MedidorR;
import com.henry.receptor.base.repository.MedidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class MedidorService {

    @Autowired
    private MedidorRepository medidorRepository;

    public List<MedidorR> getMedidores() {
        return medidorRepository.findAll();
    }

    public MedidorR getMedidor(Integer id) {
        return medidorRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public MedidorR addMedidor(MedidorR medidor) {
        return medidorRepository.save(medidor);
    }

    public MedidorR editMedidor(MedidorR medido) {
        MedidorR medidor = medidorRepository.findById(medido.getId()).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        MedidorR editMedidor = new MedidorR();
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
