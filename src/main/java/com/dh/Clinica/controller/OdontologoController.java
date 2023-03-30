package com.dh.Clinica.controller;

import com.dh.Clinica.dto.OdontologoDTO;
import com.dh.Clinica.service.IOdontologoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    IOdontologoService odontologoService;

    @GetMapping("/{id}")
    public OdontologoDTO traerOdontologo(@PathVariable Long id){
        return odontologoService.buscarOdontologo(id);
    }

    @GetMapping
    public Collection<OdontologoDTO> traerTodosOdontologos(){
        return odontologoService.buscarTodosOdontologos();
    }

    @PostMapping
    public ResponseEntity<?> crearOdontologo(@Valid @RequestBody OdontologoDTO odontologoDTO){
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@Valid @RequestBody OdontologoDTO odontologoDTO){
        odontologoService.actualizarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
