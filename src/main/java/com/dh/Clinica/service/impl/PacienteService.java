package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.PacienteDTO;
import com.dh.Clinica.entity.Paciente;
import com.dh.Clinica.repository.IPacienteRepository;
import com.dh.Clinica.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {

    private static final Logger logger = Logger.getLogger(PacienteService.class);
    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) {
        logger.info("Creando paciente...");
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
        logger.info("Paciente creado: " + paciente);
    }

    @Override
    public PacienteDTO buscarPaciente(Long id) {
        logger.info("Buscando paciente por ID...");
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent())
            logger.info("Paciente encontrado con el ID: " + id);
        pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        return pacienteDTO;
    }

    @Override
    public void actualizarPaciente(PacienteDTO pacienteDTO) {
        logger.info("Actualizando datos del Paciente: " + pacienteDTO);
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
        logger.info("Paciente con ID: " + id + " eliminando.");
    }

    @Override
    public Set<PacienteDTO> buscarTodosPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();

        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente: pacientes){
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        logger.info("Creada la lista de todos los pacientes.");
        return pacientesDTO;
    }
}
