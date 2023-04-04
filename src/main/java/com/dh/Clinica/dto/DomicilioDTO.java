package com.dh.Clinica.dto;

import com.dh.Clinica.entity.Paciente;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DomicilioDTO {
    private String calle;
    private String numero;
    private Paciente paciente;

}
