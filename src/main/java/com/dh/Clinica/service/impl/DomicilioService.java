package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.DomicilioDTO;
import com.dh.Clinica.entity.Domicilio;
import com.dh.Clinica.repository.IDomicilioRepository;
import com.dh.Clinica.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService {

    private static final Logger logger = Logger.getLogger(DomicilioService.class);
    @Autowired
    private IDomicilioRepository domicilioRepository;
    @Autowired
    ObjectMapper mapper;


    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {
        logger.info("Creando Domicilio...");
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }

    @Override
    public DomicilioDTO buscarDomicilio(Long id) {
        logger.info("Buscando domicilio por ID...");
        Optional<Domicilio> domicilio= domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if(domicilio.isPresent())
            logger.info("Domicilio encontrado con el ID: " + id);
        domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        return domicilioDTO;
    }

    @Override
    public void actualizarDomicilio(DomicilioDTO domicilioDTO) {
        logger.info("Actualizando datos del domicilio: " + domicilioDTO);
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
        logger.info("Domicilio con ID: " + id + " eliminando.");
    }

    @Override
    public Set<DomicilioDTO> buscarTodosDomicilios() {
        List<Domicilio> domicilios = domicilioRepository.findAll();

        Set<DomicilioDTO>domiciliosDTO = new HashSet<>();
        for (Domicilio domicilio: domicilios){
            domiciliosDTO.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        logger.info("Creada la lista de todos los domicilios.");
        return domiciliosDTO;
    }
}
