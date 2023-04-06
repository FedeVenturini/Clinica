package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.OdontologoDTO;
import com.dh.Clinica.entity.Odontologo;
import com.dh.Clinica.exceptions.BadRequestException;
import com.dh.Clinica.repository.IOdontologoRepository;
import com.dh.Clinica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {

    private static final Logger logger = Logger.getLogger(OdontologoService.class);
    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException {
        int matricula = odontologoDTO.getMatricula();
        Optional<Odontologo> odontologoExiste = odontologoRepository.traerMatricula(matricula);
        if (odontologoExiste.isPresent())
            throw new BadRequestException("La matricula que intenta registrar, ya existe");
        logger.info("Creando odontologo...");
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
        logger.info("Odontologo creado: " + odontologo);
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {
        logger.info("Buscando odontologo por ID...");
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent())
            logger.info("Odontologo encontrado con el ID: " + id);
        odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        return odontologoDTO;
    }

    @Override
    public void actualizarOdontologo(OdontologoDTO odontologoDTO) {
        logger.info("Actualizando datos del Odontologo: " + odontologoDTO);
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
        logger.info("Odontologo con ID: " + id + " eliminando.");
    }

    @Override
    public Set<OdontologoDTO> buscarTodosOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();

        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo: odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        logger.info("Creada la lista de todos los odontologos.");
        return odontologosDTO;
    }
}
