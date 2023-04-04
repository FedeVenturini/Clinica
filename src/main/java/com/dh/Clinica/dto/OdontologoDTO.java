package com.dh.Clinica.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private int matricula;

}
