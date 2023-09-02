package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepository materiaRepository;
	
	@Override
	public void agregar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.insertar(materia);
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionarPorCodigo(codigo);
	}

}
