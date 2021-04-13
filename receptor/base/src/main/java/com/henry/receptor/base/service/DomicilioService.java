package com.henry.receptor.base.service;

import com.henry.receptor.base.model.Cliente;
import com.henry.receptor.base.model.Domicilio;
import com.henry.receptor.base.model.MedidorR;
import com.henry.receptor.base.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;
    private ClienteService clienteService;
    private MedidorService medidorService;

    public DomicilioService(DomicilioRepository domicilioRepository, ClienteService clienteService, MedidorService medidorService) {
        this.domicilioRepository = domicilioRepository;
        this.clienteService = clienteService;
        this.medidorService = medidorService;
    }

    public Domicilio getDomicilioById(Integer id) {
        return domicilioRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public Domicilio addDomicilio(Domicilio domicilio){
        return domicilioRepository.save(domicilio);
    }

    public List<Domicilio> getDomicilios(){
        return domicilioRepository.findAll();
    }


    public void addClienteToDomicilio(Integer id, Integer clienteID) {
        Domicilio domicilio = getDomicilioById(id);
        Cliente cliente = clienteService.getCliente(clienteID);
        domicilio.setCliente(cliente);
        domicilioRepository.save(domicilio);
    }

    public void addMedidorToDomicilio(Integer id, Integer medidorId) {
        Domicilio domicilio = getDomicilioById(id);
        MedidorR medidor = medidorService.getMedidor(medidorId);
        domicilio.setMedidor(medidor);
        domicilioRepository.save(domicilio);
    }

    public void deleteDomicilioByid(Integer id) {
        domicilioRepository.deleteById(id);
    }
}
