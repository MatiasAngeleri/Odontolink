package com.odontolink.request;

import com.odontolink.model.Paciente;
import com.odontolink.model.TurnoData;

public class CitaRequest {
	private Paciente paciente;
	private TurnoData turnoData;

	public Paciente getPaciente() {
		return paciente;
	}

	public TurnoData getTurnoData() {
		return turnoData;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setTurnoData(TurnoData turnoData) {
		this.turnoData = turnoData;
	}

}
