package com.odontolink.rest;

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

import com.odontolink.dao.MedicoDao;
import com.odontolink.model.Medico;
import com.odontolink.utils.TurnoUtils;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("medicos")
public class MedicoRest {
	@Autowired
	private MedicoDao medicoDao;

	@PostMapping("alta")
	public ResponseEntity<Medico> altaMedico(@RequestBody Medico medico) {
		medicoDao.save(medico);
		return ResponseEntity.ok(medico);
	}

	@GetMapping("listar")
	public List<Medico> listarMedicos() {			 
		List <Medico> medicos = medicoDao.findAll();
		for (Medico medico : medicos) {
			medico.setTurnos(TurnoUtils.calcularTurnos(medico.getId()));
		}
		return medicos;

	}

	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<Integer> eliminarMedico(@PathVariable("id") Integer id) {
		medicoDao.deleteById(id);
		return ResponseEntity.ok(id);
	}

	@PutMapping("actualizar")
	public void actualizarMedico(@RequestBody Medico user) {
		medicoDao.save(user);
	}

	@DeleteMapping("deleteAll")
	public void eliminarMedicos() {
		medicoDao.deleteAll();
	}
}
