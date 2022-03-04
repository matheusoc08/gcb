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
    private String medCrm;
    @NotBlank
    @Size(min = 10, max = 15)
    private String medTelefone;
    @NotBlank
    @Size(min = 11, max = 15)
    private String medCelular;
    @NotNull
    private int espIdPrimaria;
    @NotNull
    private int espIdSecundaria;
    @NotBlank
    private String medCep;

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

    public String getMedCrm() {
        return medCrm;
    }

    public void setMedCrm(String medCrm) {
        this.medCrm = medCrm;
    }

    public String getMedTelefone() {
        return medTelefone;
    }

    public void setMedTelefone(String medTelefone) {
        this.medTelefone = medTelefone;
    }

    public String getMedCelular() {
        return medCelular;
    }

    public void setMedCelular(String medCelular) {
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

    public String getMedCep() {
        return medCep;
    }

    public void setMedCep(String medCep) {
        this.medCep = medCep;
    }

}
