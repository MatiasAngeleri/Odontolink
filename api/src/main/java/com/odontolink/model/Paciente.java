package com.odontolink.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paciente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6573032670108310402L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nombre;

	@Column
	private String apellido;

	@Column
	private String email;

	@Column
	private String celular;

	@Column
	private String tipoyNrDNI;

	@Column
	private String fechaNacimiento;

	@Column
	private String domicilio;

	@Column
	private String domicilioNr;

	@Column
	private String domicilioDtoPiso;

	@Column
	private String ciudad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTipoyNrDNI() {
		return tipoyNrDNI;
	}

	public void setTipoyNrDNI(String tipoyNrDNI) {
		this.tipoyNrDNI = tipoyNrDNI;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getDomicilioNr() {
		return domicilioNr;
	}

	public void setDomicilioNr(String domicilioNr) {
		this.domicilioNr = domicilioNr;
	}

	public String getDomicilioDtoPiso() {
		return domicilioDtoPiso;
	}

	public void setDomicilioDtoPiso(String domicilioDtoPiso) {
		this.domicilioDtoPiso = domicilioDtoPiso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
