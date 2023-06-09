package com.dh.Clinica.repository;

import com.dh.Clinica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    @Query("from Odontologo o where o.matricula = :matricula")
    Optional<Odontologo> traerMatricula(@Param("matricula") int matricula);
}
