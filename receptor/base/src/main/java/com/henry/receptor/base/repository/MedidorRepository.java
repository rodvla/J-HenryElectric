package com.henry.receptor.base.repository;

import com.henry.receptor.base.model.MedidorR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedidorRepository extends JpaRepository<MedidorR, Integer> {
}

