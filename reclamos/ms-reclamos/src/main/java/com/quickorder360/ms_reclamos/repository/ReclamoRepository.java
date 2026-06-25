package com.quickorder360.ms_reclamos.repository;

import com.quickorder360.ms_reclamos.model.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {

}
