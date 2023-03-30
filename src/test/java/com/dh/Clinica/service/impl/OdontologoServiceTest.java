package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.OdontologoDTO;
import com.dh.Clinica.service.IOdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void crearEstudianteTest(){
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Alberto");
        odontologoDTO.setApellido("Ventu");
        odontologoDTO.setMatricula(222222);

        odontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO odontologoBeto = odontologoService.buscarOdontologo(1L);

        assertTrue(odontologoBeto != null);
    }
}