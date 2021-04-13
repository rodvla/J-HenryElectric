package com.henry.receptor.base.service;

import com.henry.receptor.base.model.MedidaR;
import com.henry.receptor.base.model.MedidorR;
import com.henry.receptor.base.repository.DomicilioRepository;
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

    @Autowired
    private MedidaService medidaService;

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
        MedidorR medidor = getMedidor(medido.getId());
        MedidorR editMedidor = new MedidorR();
        editMedidor.setId(medidor.getId());
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

    public void addMedidaToMedidor(Integer idMedidor, MedidaR medida) {
        MedidorR medidorR = getMedidor(idMedidor);
        medida.setIdMedidor(idMedidor);
        MedidaR medidaAdd = medidaService.addMedida(medida);
        List<MedidaR> lista = medidorR.getMedidas();
        lista.add(medidaAdd);
        medidorRepository.save(medidorR);
    }
}
