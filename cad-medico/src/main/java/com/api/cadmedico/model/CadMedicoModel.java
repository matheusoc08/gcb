package com.api.cadmedico.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MED_MEDICO")
public class CadMedicoModel implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long medId;
    @Column(nullable = false, length = 1)
    private String medHabilitado;
    @Column(nullable = false)
    private LocalDateTime medDataCadastro;
    @Column(nullable = true)
    private LocalDateTime medDataAtualizacao;
    @Column(nullable = false, length = 120)
    private String medNome;
    @Column(nullable = false, unique = true, length = 7)
    private Long medCrm;
    @Column(nullable = false, length = 15)
    private Long medTelefone;
    @Column(nullable = false, length = 15)
    private Long medCelular;
    @Column(nullable = false)
    private int espIdPrimaria;
    @Column(nullable = false)
    private int espIdSecundaria;
    @Column(nullable = false, length = 8)
    private Long medCep;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getMedId() {
        return medId;
    }

    public void setMedId(Long medId) {
        this.medId = medId;
    }

    public String getMedHabilitado() {
        return medHabilitado;
    }

    public void setMedHabilitado(String medHabilitado) {
        this.medHabilitado = medHabilitado.toUpperCase();
    }

    public LocalDateTime getMedDataCadastro() {
        return medDataCadastro;
    }

    public void setMedDataCadastro(LocalDateTime medDataCadastro) {
        this.medDataCadastro = medDataCadastro;
    }

    public LocalDateTime getMedDataAtualizacao() {
        return medDataAtualizacao;
    }

    public void setMedDataAtualizacao(LocalDateTime medDataAtualizacao) {
        this.medDataAtualizacao = medDataAtualizacao;
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
