package com.odontolink.response;

import java.util.List;

import com.odontolink.model.Cita;
import com.odontolink.model.Medico;
import com.odontolink.model.Paciente;

public class CitaResponse {

	private  List<Paciente> pacientes ;
	private  List<Medico> medicos;
	private  List<Cita> citas;
	
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public List<Medico> getMedicos() {
		return medicos;
	}
	public List<Cita> getCitas() {
		return citas;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	
	
	 
	
}
