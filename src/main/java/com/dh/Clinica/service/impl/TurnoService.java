package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.TurnoDTO;
import com.dh.Clinica.entity.Turno;
import com.dh.Clinica.repository.ITurnoRepository;
import com.dh.Clinica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    private static final Logger logger = Logger.getLogger(TurnoService.class);
    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        logger.info("Creando turno...");
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
        logger.info("Odontologo creado: " + turno);
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        logger.info("Buscando turno por ID...");
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent())
            logger.info("Turno encontrado con el ID: " + id);
        turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        return turnoDTO;
    }

    @Override
    public void actualizarTurno(TurnoDTO turnoDTO) {
        logger.info("Actualizando datos del Turno: " + turnoDTO);
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
        logger.info("Turno con ID: " + id + " eliminando.");
    }

    @Override
    public Set<TurnoDTO> buscarTodosTurnos() {
        List<Turno> turnos = turnoRepository.findAll();

        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for (Turno turno: turnos){
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        logger.info("Creada la lista de todos los turnos.");
        return turnosDTO;
    }
}
