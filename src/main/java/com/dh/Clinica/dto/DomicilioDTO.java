package com.dh.Clinica.dto;

import com.dh.Clinica.entity.Paciente;

public class DomicilioDTO {
    private String calle;
    private String numero;
    private Paciente paciente;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
