package com.dh.Clinica.dto;

import com.dh.Clinica.entity.Odontologo;
import com.dh.Clinica.entity.Paciente;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class TurnoDTO {
    private Long id;
    private Date fechaTurno;
    private Odontologo odontologo;
    private Paciente paciente;
}
