package isi.died.parcial01.ejercicio02.app;

import isi.died.parcial01.ejercicio02.dominio.*;

import java.util.Collection;
import java.util.List;


public interface MySysAcad {
	
	public void registrarMateria(Materia d);
	
	
	public void registrarDocente(Docente d) ;
	
	
	public void registrarAlumnos(Alumno d);
	/**
	 * crea una nueva instancia de Inscripcion y 
	 * asigna la inscripcion a la lista de inscripciones del alumno, 
	 * de la materia y del docente
	 */
	public void inscribirAlumnoCursada(Docente d,Alumno a, Materia m,Integer cicloLectivo);

	/**
	 * crea una nueva instancia de Inscripcion y 
	 * asigna la inscripcion a la lista de inscripciones del alumno, 
	 * de la materia y del docente
	 */
	public void inscribirAlumnoExamen(Docente d,Alumno a, Materia m);
	

	public default List<Examen>topNExamenes(Alumno a, Integer n, Integer nota){

		List<isi.died.parcial01.ejercicio02.dominio.Examen> e2 = a.getExamenes();
		List<Examen> e3;

		for( Examen e : e2){
			if(e.getNota() == nota){
				e3.add(e);
			}
		}

		// en teoria deberia poder ordenarlo aqui
		Collection.sort(e, Examen.Comparators.nota);



		return e3;
	}
}
