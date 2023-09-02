package com.example.demo.repository.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@Column(name = "matr_id")
	private Integer id;
	
	@Column(name = "matr_fecha")
	private LocalDate fecha;
	
	@Column(name = "matr_hilo")
	private String hilo;
	
	@ManyToOne
	@JoinColumn(name = "matr_id_estudiante")
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name = "matr_id_materia")
	private Materia materia;

	//SET Y GET 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	

	public String getHilo() {
		return hilo;
	}

	public void setHilo(String hilo) {
		this.hilo = hilo;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fecha=" + fecha + ", estudiante=" + estudiante + ", materia=" + materia + "]";
	}
	
	
	
}
