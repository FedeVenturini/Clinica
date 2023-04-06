package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.OdontologoDTO;
import com.dh.Clinica.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    public void crearOdontologoTest() throws BadRequestException {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Fede");
        odontologoDTO.setApellido("Ventu");
        odontologoDTO.setMatricula(32325789);

        odontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO odontologoTest = odontologoService.buscarOdontologo(1L);

        assertTrue(odontologoTest != null);
    }

    @Test
    public void buscarOdontologoTest() throws BadRequestException {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("fed");
        odontologoDTO.setApellido("Ventu");
        odontologoDTO.setMatricula(142123455);

        odontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO odontologoTest = odontologoService.buscarOdontologo(1L);

        assertEquals(odontologoTest.getNombre(), "fed");
    }
}