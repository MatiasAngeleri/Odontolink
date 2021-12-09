package com.odontolink.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odontolink.model.Medico;

public interface MedicoDao extends JpaRepository<Medico, Integer> {

}
