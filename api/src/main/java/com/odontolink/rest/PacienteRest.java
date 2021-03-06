package com.odontolink.rest;

import java.util.List;
import java.util.Optional;

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

import com.odontolink.dao.PacienteDao;
import com.odontolink.model.Paciente;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("pacientes")
public class PacienteRest {
	@Autowired
	private PacienteDao pacienteDao;

	@PostMapping("alta")
	public ResponseEntity<Paciente> alta(@RequestBody Paciente paciente) {

		Paciente pacienteDB = pacienteDao.findPaciente(paciente.getNombre(), paciente.getApellido(),
				paciente.getTipoyNrDNI());
		if (null == pacienteDB) {
			pacienteDao.save(paciente);
			return ResponseEntity.ok(paciente);
		} else {
			return ResponseEntity.ok(pacienteDao.findById(pacienteDB.getId()).get());
		}

	}

	@GetMapping("listar")
	public List<Paciente> listar() {
		return pacienteDao.findAll();

	}
	 
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<Integer> eliminarPaciente(@PathVariable("id") Integer id) {
		pacienteDao.deleteById(id);
		return ResponseEntity.ok(id);
	}

	@PutMapping("actualizar")
	public void actualizarPaciente(@RequestBody Paciente paciente) {
		pacienteDao.save(paciente);
	}

	@DeleteMapping("deleteAll")
	public void eliminarPaciente() {
		pacienteDao.deleteAll();
	}

}
