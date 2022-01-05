package com.appbtd.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appbtd.modelo.Tarea;
import com.appbtd.servicio.ITarea;

@RestController
@CrossOrigin
@RequestMapping("/tarea")
public class Controlador {

	@Autowired
	private ITarea repositorio;
	
	@GetMapping
	public List<Tarea> getTareas(){
		return repositorio.findAll();
	}
	
	@PostMapping
	public Object addTarea(@RequestBody Tarea t) {
		t.setEstadoEdit(false);
		return repositorio.save(t);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteTarea(@PathVariable int id) {
		repositorio.deleteById(id);
	}
	
	@GetMapping(value = "/{id}")
	public Object getTarea(@PathVariable int id) {
		return repositorio.findById(id);
	}
	
	@PutMapping
	public void updateTarea(@RequestBody Tarea t) {
		repositorio.saveAndFlush(t);
	}
}
