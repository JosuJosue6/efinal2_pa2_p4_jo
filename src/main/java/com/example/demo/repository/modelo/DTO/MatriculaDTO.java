package com.example.demo.repository.modelo.DTO;

public class MatriculaDTO {

	private String cedulaEstudiante;
	
	private String nombreMateria;
	
	private String cedulaProfesor;
	
	private String nombreHilo;

	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public String getCedulaProfesor() {
		return cedulaProfesor;
	}

	public void setCedulaProfesor(String cedulaProfesor) {
		this.cedulaProfesor = cedulaProfesor;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public MatriculaDTO(String cedulaEstudiante, String nombreMateria, String cedulaProfesor, String nombreHilo) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.nombreMateria = nombreMateria;
		this.cedulaProfesor = cedulaProfesor;
		this.nombreHilo = nombreHilo;
	}

	public MatriculaDTO() {

	}
	
	
	
}
