package com.odontolink.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odontolink.model.Paciente;             

public interface PacienteDao extends JpaRepository<Paciente, Integer> {
	@Query("select pac from Paciente pac where pac.nombre = :nombre and pac.apellido = :apellido and pac.tipoyNrDNI = :tipoyNrDNI ")
	Paciente findPaciente(@Param("nombre") String nombre , @Param("apellido") String apellido ,
			 @Param("tipoyNrDNI") String tipoyNrDNI);
}
