package com.dh.Clinica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@Table
@Getter
@Setter
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private java.sql.Date fechaDeIngreso;
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private Set<Domicilio> domicilios = new HashSet<>();
}
