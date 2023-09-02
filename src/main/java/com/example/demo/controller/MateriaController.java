package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
	//Insertar
	@GetMapping("/nuevo")
	public String paginaNuevo(Materia materia) {
		return "vistaNuevaMateria";
	}
	
	@PostMapping("/registro")
	public String registrar(Materia materia) {
		this.materiaService.agregar(materia);
		return "redirect:/materias/nuevo";
	}
}
