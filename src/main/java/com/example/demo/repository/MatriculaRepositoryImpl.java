package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.DTO.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	public List<MatriculaDTO> seleccionarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<MatriculaDTO> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.example.demo.repository.modelo.DTO.MatriculaDTO(m.estudiante.cedula, m.materia.nombre, m.materia.cedulaProfesor, m.hilo) FROM Matricula m",
				MatriculaDTO.class);
		return myQuery.getResultList();
	}

}
