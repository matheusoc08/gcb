package com.api.cadmedico.repositories;

import com.api.cadmedico.model.CadMedicoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadMedicoRepository extends JpaRepository<CadMedicoModel, Long> {

    boolean existsByMedCrm(String medCrm);

}
