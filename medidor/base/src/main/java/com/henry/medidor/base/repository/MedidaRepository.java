package com.henry.medidor.base.repository;

import com.henry.medidor.base.model.Medida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedidaRepository extends JpaRepository<Medida, Integer> {
}