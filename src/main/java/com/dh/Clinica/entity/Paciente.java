package com.dh.Clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.Set;
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@Getter
@Setter
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
    private Date fechaDeAlta;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos;
}
