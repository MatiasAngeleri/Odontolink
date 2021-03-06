package com.odontolink.utils;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.odontolink.model.TurnoData;

public class TurnoUtils {

	public static ArrayList<TurnoData> calcularTurnos(int idMedico) {
		ArrayList<TurnoData> turnos = new ArrayList<TurnoData>();
		int dias = 1;

		ZoneId zone = ZoneId.of("America/Argentina/Buenos_Aires");
		Duration d = Duration.ofMinutes(20);

		for (int dia = 0; dia < dias; dia++) {
			TurnoData turno = new TurnoData();
			Period periodo = Period.ofDays(dia);
			LocalDate hoyDonamico = LocalDate.now();
			LocalTime hora = LocalTime.of(8 + dia, 0);
			hoyDonamico = hoyDonamico.plusDays(3);
			LocalDate diaTurno = hoyDonamico.plus(periodo);
			LocalDateTime fechaHoraTurno = LocalDateTime.of(diaTurno, hora);

			turno.setMes(hoyDonamico.getMonthValue());
			turno.setAnio(hoyDonamico.getYear());
			turno.setDia(hoyDonamico.getDayOfMonth()+dia);

			Instant start = fechaHoraTurno.atZone(zone).toInstant();
			//Instant stop = start.plus(d);
			DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
		            .withZone(zone);
		
			ArrayList<String> fechashoras = new ArrayList<String>();
			for (int i = 0; i < 15; i++) {
				String fechahr = new String();
				start = start.plus(d); 
				fechahr = DATE_TIME_FORMATTER.format(start.plus(d));
				fechashoras.add(fechahr);
			} 
			turno.setFechasYhorasInicio(fechashoras);
			turno.setIdMedico(idMedico);
			turnos.add(turno);
		}

		return turnos;
	}
}
