package isi.died.parcial01.ejercicio02.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import isi.died.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died.parcial01.ejercicio02.dominio.*;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) throws profesorNoInscriptoException {

		List<Docente> lista= m.docentes;
		boolean aux= false;
		for(Docente l: lista){
			if(l.getNombre() == d.getNombre()){
				aux= true;
			}
		}

		if(!aux) {
			throw new profesorNoInscriptoException("El profesor no pertenece a la materia");
		} else {
			Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
			d.agregarInscripcion(insc);
			a.addCursada(insc);
			m.addInscripcion(insc);

		}

		// DESCOMENTAR Y gestionar excepcion

		try {
			DB.guardar(insc);
		} catch (IOException e){
			e.printStackTrace();
			throw new BaseDeDatosException();
		}




	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		DB.guardar(e);
	}



	public void registrarNota(Examen e, Integer nota){
		Alumno a = e.getAlumno();
		Inscripcion e1 = a.getMateriasCursadas(); // cree get de la lista en alumno

		e.setNota(nota);
		if (nota >= 6){
			e1(e1.size()-1).setEstado(PROMOCIONADO);
			System.out.println("Nota mayor a 6");
		}

	}




}
