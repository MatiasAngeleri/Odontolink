package com.odontolink.model;

import java.io.Serializable;
import java.util.ArrayList;

public class TurnoData implements Serializable {
	/**
	 * No tiene que se entity en la BD
	 */
	private static final long serialVersionUID = -533273503776129795L;

 
	private Integer id;	 
	private Integer idPaciente; 
	private Integer idMedico;	 
	private Integer anio; 
	private Integer mes; 
	private Integer dia; 
	private ArrayList<String> fechasYhorasInicio;	 
	private String fechaHoraFin;
	private String fechaHoraTurno;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	 
	public String getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(String fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

	public ArrayList<String> getFechasYhorasInicio() {
		return fechasYhorasInicio;
	}

	public void setFechasYhorasInicio(ArrayList<String> fechasYhorasInicio) {
		this.fechasYhorasInicio = fechasYhorasInicio;
	}

	public String getFechaHoraTurno() {
		return fechaHoraTurno;
	}

	public void setFechaHoraTurno(String fechaHoraTurno) {
		this.fechaHoraTurno = fechaHoraTurno;
	}
}
