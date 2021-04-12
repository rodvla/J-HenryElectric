package com.henry.medidor.base.repository;

import com.henry.medidor.base.model.Medidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedidorRepository extends JpaRepository<Medidor, Integer> {
}
