package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.DTO.MatriculaDTO;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private IMatriculaService matriculaService;

	// Insertar
	@GetMapping("/nuevo")
	public String paginaNuevo(Matricula matricula) {
		return "vistaNuevaMatricula";
	}

	@PostMapping("/registro")
	public String registrar(@RequestParam("cedula") String cedula, @RequestParam("c1") String c1,
			@RequestParam("c2") String c2, @RequestParam("c3") String c3, @RequestParam("c4") String c4,
			Matricula matricula) {
		List<String> lista = new ArrayList<>();
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		lista.add(c4);
		this.matriculaService.agregar(lista,cedula,matricula);
		return "redirect:/matriculas/nuevo";
	}
	
	//vista Lista 
	@GetMapping("/buscar")
	public String buscar(Model model) {
		List<MatriculaDTO> lista= this.matriculaService.buscarTodos();
		model.addAttribute("lista",model);
		return "vistaListaMatriculas";
	}

}
