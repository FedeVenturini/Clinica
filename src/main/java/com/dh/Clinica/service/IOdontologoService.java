package com.dh.Clinica.service;

import com.dh.Clinica.dto.OdontologoDTO;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface IOdontologoService {
    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO buscarOdontologo(Long id);
    void actualizarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id);
    Set<OdontologoDTO> buscarTodosOdontologos();
}
