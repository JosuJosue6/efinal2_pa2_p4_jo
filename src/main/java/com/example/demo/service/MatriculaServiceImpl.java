package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.DTO.MatriculaDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	@Autowired
	private IEstudianteService estudianteService;	
	
	@Autowired
	private IMateriaService materiaService;
	
	@Override
	public void agregar(List<String>lista, String cedula,Matricula matricula) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.estudianteService.buscarPorCedula(cedula);

		List<Matricula> matriculas = new ArrayList<>();
		
		for(int i = 0; i< lista.size();i++) {
			Matricula m1 = new Matricula();
			Materia materia = this.materiaService.buscarPorCodigo(lista.get(i));
			
			m1.setFecha(LocalDate.now());
			m1.setEstudiante(estudiante);
			m1.setMateria(materia);
			matriculas.add(m1);
		}
		//insertar con mulihilos
		matriculas.parallelStream().forEach(mat ->{ 
			mat.setHilo(Thread.currentThread().getName());
			this.matriculaRepository.insertar(mat);});
	}

	@Override
	public List<MatriculaDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return this.matriculaRepository.seleccionarTodos();
	}

}
