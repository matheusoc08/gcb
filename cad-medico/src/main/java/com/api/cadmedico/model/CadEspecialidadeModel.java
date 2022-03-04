package com.api.cadmedico.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESP_ESPECIALIDADE")
public class CadEspecialidadeModel implements Serializable {

    private static final int serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long esp_id;
    @Column(nullable = false, length = 20)
    private String esp_nome;

    public static int getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getEsp_id() {
        return esp_id;
    }

    public void setEsp_id(Long esp_id) {
        this.esp_id = esp_id;
    }

    public String getEsp_nome() {
        return esp_nome;
    }

    public void setEsp_nome(String esp_nome) {
        this.esp_nome = esp_nome;
    }

}