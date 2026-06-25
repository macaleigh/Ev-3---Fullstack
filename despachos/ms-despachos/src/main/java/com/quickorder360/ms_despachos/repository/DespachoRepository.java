package com.quickorder360.ms_despachos.repository;

import com.quickorder360.ms_despachos.model.Despacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespachoRepository extends JpaRepository<Despacho, Long> {

}