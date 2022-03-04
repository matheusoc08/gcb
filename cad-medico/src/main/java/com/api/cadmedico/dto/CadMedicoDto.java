package com.api.cadmedico.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CadMedicoDto {

    @NotBlank
    @Size(max = 1)
    private String medHabilitado;
    @NotBlank
    private String medNome;
    @NotBlank
    private Long medCrm;
    @NotBlank
    @Size(min = 10, max = 15)
    private Long medTelefone;
    @NotBlank
    @Size(min = 11, max = 15)
    private Long medCelular;
    @NotNull
    private int espIdPrimaria;
    @NotNull
    private int espIdSecundaria;
    @NotBlank
    private Long medCep;

    public String getMedHabilitado() {
        return medHabilitado;
    }

    public void setMedHabilitado(String medHabilitado) {
        this.medHabilitado = medHabilitado;
    }

    public String getMedNome() {
        return medNome;
    }

    public void setMedNome(String medNome) {
        this.medNome = medNome;
    }

    public Long getMedCrm() {
        return medCrm;
    }

    public void setMedCrm(Long medCrm) {
        this.medCrm = medCrm;
    }

    public Long getMedTelefone() {
        return medTelefone;
    }

    public void setMedTelefone(Long medTelefone) {
        this.medTelefone = medTelefone;
    }

    public Long getMedCelular() {
        return medCelular;
    }

    public void setMedCelular(Long medCelular) {
        this.medCelular = medCelular;
    }

    public int getEspIdPrimaria() {
        return espIdPrimaria;
    }

    public void setEspIdPrimaria(int espIdPrimaria) {
        this.espIdPrimaria = espIdPrimaria;
    }

    public int getEspIdSecundaria() {
        return espIdSecundaria;
    }

    public void setEspIdSecundaria(int espIdSecundaria) {
        this.espIdSecundaria = espIdSecundaria;
    }

    public Long getMedCep() {
        return medCep;
    }

    public void setMedCep(Long medCep) {
        this.medCep = medCep;
    }

}
