package com.odontolink.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odontolink.model.Cita;
import com.odontolink.model.Paciente;             

public interface CitaDao extends JpaRepository<Cita, Integer> {
	 
}
