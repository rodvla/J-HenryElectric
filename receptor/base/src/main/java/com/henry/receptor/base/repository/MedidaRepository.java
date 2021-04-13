package com.henry.receptor.base.repository;

import com.henry.receptor.base.model.MedidaR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MedidaRepository extends JpaRepository<MedidaR, Integer> {

    @Query(nativeQuery = true, value = "select * from medidar where id_medidor = :idMedidor and fecha between :from and :to" )
    List<MedidaR> findByDateBetween(Integer idMedidor, String from, String to);

}