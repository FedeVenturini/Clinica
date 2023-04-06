package com.dh.Clinica.dto;

import com.dh.Clinica.entity.Domicilio;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
    private Domicilio domicilio;
}
