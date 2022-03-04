package com.api.cadmedico.dto;

import javax.validation.constraints.NotBlank;

public class CadEspecialidadeDto {

    @NotBlank
    private String esp_nome;

    public String getEsp_nome() {
        return esp_nome;
    }

    public void setEsp_nome(String esp_nome) {
        this.esp_nome = esp_nome;
    }

}