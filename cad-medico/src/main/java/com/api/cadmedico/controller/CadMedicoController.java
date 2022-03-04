package com.api.cadmedico.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.api.cadmedico.dto.CadMedicoDto;
import com.api.cadmedico.model.CadMedicoModel;
import com.api.cadmedico.services.CadMedicoService;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cad-medico")
public class CadMedicoController {

    final CadMedicoService cadMedicoService;

    public CadMedicoController(CadMedicoService cadMedicoService) {
        this.cadMedicoService = cadMedicoService;
    }

    @PostMapping("/i/")
    public ResponseEntity<Object> postMedico(@RequestBody @Valid CadMedicoDto cadMedicoDto) {
        if (cadMedicoDto.getEspIdSecundaria() == cadMedicoDto.getEspIdPrimaria()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflito: A especialidade médica não pode ser duplicada.");
        }

        if (cadMedicoService.existsByMedCrm(cadMedicoDto.getMedCrm())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflito: Já existe um médico cadastrado com esse CRM.");
        }

        var cadMedicoModel = new CadMedicoModel();
        BeanUtils.copyProperties(cadMedicoDto, cadMedicoModel);
        cadMedicoModel.setMedDataCadastro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(cadMedicoService.salvar(cadMedicoModel));
    }

    @GetMapping("/s/")
    public ResponseEntity<List<CadMedicoModel>> getTodosMedicos() {
        return ResponseEntity.status(HttpStatus.OK).body(cadMedicoService.findAll());
    }

    @GetMapping("/s/i/{id}")
    public ResponseEntity<Object> getUnicoMedico(@PathVariable(value = "id") long id) {
        Optional<CadMedicoModel> cadMedicoModelOptional = cadMedicoService.findById(id);
        if (!cadMedicoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não localizado pelo id informado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cadMedicoModelOptional.get());
    }

    @GetMapping("/s/n/{nome}")
    public ResponseEntity<Object> getUnicoMedico(@PathVariable(value = "nome") String medNome) {

        var cadMedicoModel = new CadMedicoModel();
        cadMedicoModel.getMedNome().contains(medNome);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teste");

        // if (!cadMedicoModelOptional.isPresent()) {
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não
        // localizado pelo id informado.");
        // }
        // return
        // ResponseEntity.status(HttpStatus.OK).body(cadMedicoModelOptional.get());
    }

    @PutMapping("/u/{id}")
    public ResponseEntity<Object> editarMedico(@PathVariable(value = "id") long id,
            @RequestBody @Valid CadMedicoDto cadMedicoDto) {
        Optional<CadMedicoModel> cadMedicoModelOptional = cadMedicoService.findById(id);
        if (!cadMedicoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não localizado pelo id informado.");
        }

        var cadMedicoModel = new CadMedicoModel();
        BeanUtils.copyProperties(cadMedicoDto, cadMedicoModel);
        cadMedicoModel.setMedId(cadMedicoModelOptional.get().getMedId());
        cadMedicoModel.setMedDataCadastro(cadMedicoModelOptional.get().getMedDataCadastro());
        cadMedicoModel.setMedDataAtualizacao(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.OK).body(cadMedicoService.salvar(cadMedicoModel));
    }

    @PatchMapping("/d/{id}")
    public ResponseEntity<Object> desativarMedico(@PathVariable(value = "id") long id,
            @RequestBody CadMedicoDto cadMedicoDto) {
        Optional<CadMedicoModel> cadMedicoModelOptional = cadMedicoService.findById(id);
        if (!cadMedicoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não localizado pelo id informado.");
        }

        var cadMedicoModel = new CadMedicoModel();
        BeanUtils.copyProperties(cadMedicoDto, cadMedicoModel);
        cadMedicoModel = cadMedicoModelOptional.get();
        cadMedicoModel.setMedHabilitado(cadMedicoDto.getMedHabilitado());
        cadMedicoModel.setMedDataAtualizacao(LocalDateTime.now(ZoneId.of("UTC")));

        // return ResponseEntity.status(HttpStatus.OK).body("Medico desativado com
        // sucesso!");
        return ResponseEntity.status(HttpStatus.OK).body(cadMedicoService.salvar(cadMedicoModel));
    }

}
