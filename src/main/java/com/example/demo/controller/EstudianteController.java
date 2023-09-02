package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;
	
	//insertar
	@GetMapping("/nuevo")
	public String paginaNuevo(Estudiante estudiante) {
		return "vistaNuevoEstudiante";
	}
	
	@PostMapping("/registro")
	public String registrar(Estudiante estudiante) {
		this.estudianteService.agregar(estudiante);
		return "redirect:/estudiantes/nuevo";
	}
	
}
