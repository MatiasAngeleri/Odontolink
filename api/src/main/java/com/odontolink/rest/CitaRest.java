package com.odontolink.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odontolink.dao.CitaDao;
import com.odontolink.dao.MedicoDao;
import com.odontolink.dao.PacienteDao;
import com.odontolink.model.Cita;
import com.odontolink.model.Medico;
import com.odontolink.model.Paciente;
import com.odontolink.model.TurnoData;
import com.odontolink.request.CitaRequest;
import com.odontolink.response.CitaResponse;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("citas")
public class CitaRest {
	@Autowired
	private CitaDao citaDao;
	@Autowired
	private PacienteDao pacienteDao;
	
	@Autowired
	private MedicoDao medicoDao;
	
	
	@PostMapping("reservar")
	public ResponseEntity<Cita> reservar(@RequestBody CitaRequest request) {	 
		 
		Paciente paciente = request.getPaciente();
		TurnoData turnoData = request.getTurnoData();
		
		Cita cita = new Cita();
		Paciente pacienteDB = pacienteDao.findPaciente(paciente.getNombre(), paciente.getApellido(),
				paciente.getTipoyNrDNI());
		
		if (null == pacienteDB) {
			pacienteDao.save(paciente);
			pacienteDB =  pacienteDao.findPaciente(paciente.getNombre(), paciente.getApellido(),
						paciente.getTipoyNrDNI());
			if(pacienteDB != null){
				 
				cita.setIdMedico(turnoData.getIdMedico());
				cita.setIdPaciente(pacienteDB.getId());
				cita.setFechaHoraTurno(turnoData.getFechaHoraTurno());
//				cita.setAnio(turnoData.getAnio());
//				cita.setDia(turnoData.getDia());
//				cita.setMes(turnoData.getMes());0
				cita.setEstado(0);
				citaDao.save(cita);
			}
		 
		} else {
			pacienteDB = pacienteDao.findById(pacienteDB.getId()).get();
			if(pacienteDB != null){				 
				cita.setIdMedico(turnoData.getIdMedico());
				cita.setIdPaciente(pacienteDB.getId());
//				cita.setFechaHoraTurno(turnoData.getFechaHoraTurno());
//				cita.setAnio(turnoData.getAnio());
//				cita.setDia(turnoData.getDia());
//				cita.setMes(turnoData.getMes());
				cita.setEstado(0);
				citaDao.save(cita);
			}
			
		}
		return ResponseEntity.ok(cita);
	}

	@GetMapping("listar")
	public CitaResponse listarCitas() {	
		CitaResponse citaResponse = new CitaResponse();
		List<Cita> citas = citaDao.findAll();			
		List<Medico> medicos =  medicoDao.findAll();
		List<Paciente> pacientes =  pacienteDao.findAll();
		citaResponse.setCitas(citas);
		citaResponse.setMedicos(medicos);
		citaResponse.setPacientes(pacientes);
		return citaResponse;
// ArrayList<Cita> citasResponseList = new ArrayList<Cita>();			
//		for (Cita cita : citas) {
//			Cita citaResponse = new Cita();			 
//			citaResponse.setFechaHoraTurno(cita.getFechaHoraTurno());
//			citaResponse.setEstado(cita.getEstado());
//			citasResponseList.add(citaResponse);
//		}
//		return citasResponseList;
	}

	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<Integer> eliminar(@PathVariable("id") Integer id) {
		citaDao.deleteById(id);
		return ResponseEntity.ok(id);
	}

	@PutMapping("actualizar")
	public void actualizar(@RequestBody Cita cita) {
		citaDao.save(cita);
	}

	@DeleteMapping("deleteAll")
	public void eliminarCitas() {
		citaDao.deleteAll();
	}

}
