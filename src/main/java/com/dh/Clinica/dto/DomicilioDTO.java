package com.dh.Clinica.dto;

import com.dh.Clinica.entity.Paciente;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DomicilioDTO {
    private Long id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;
}
