package com.api.cadmedico.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.api.cadmedico.model.CadMedicoModel;
import com.api.cadmedico.repositories.CadMedicoRepository;

import org.springframework.stereotype.Service;

@Service
public class CadMedicoService {
    final CadMedicoRepository cadMedicoRepository;

    public CadMedicoService(CadMedicoRepository cadMedicoRepository) {
        this.cadMedicoRepository = cadMedicoRepository;
    }

    @Transactional
    public CadMedicoModel salvar(CadMedicoModel cadMedicoModel) {
        return cadMedicoRepository.save(cadMedicoModel);
    }

    public List<CadMedicoModel> findAll() {
        return cadMedicoRepository.findAll();
    }

    public boolean existsByMedCrm(String medCrm) {
        return cadMedicoRepository.existsByMedCrm(medCrm);
    }

    public Optional<CadMedicoModel> findById(long id) {
        return cadMedicoRepository.findById(id);
    }

}
