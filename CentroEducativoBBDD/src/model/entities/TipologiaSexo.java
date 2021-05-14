package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipologiasexo database table.
 * 
 */
@Entity
@NamedQuery(name="TipologiaSexo.findAll", query="SELECT t FROM TipologiaSexo t")
public class TipologiaSexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripción;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="tipologiasexo")
	private List<Estudiante> estudiantes;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="tipologiasexo")
	private List<Profesor> profesors;

	public TipologiaSexo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripción() {
		return this.descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setTipologiasexo(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setTipologiasexo(null);

		return estudiante;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setTipologiasexo(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setTipologiasexo(null);

		return profesor;
	}

	@Override
	public String toString() {
		return descripción;
	}

}