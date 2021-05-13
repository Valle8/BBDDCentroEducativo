package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;


public class ControladorValoracionMateria {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoBBDD");
	
	// instancia del singleton
	private static ControladorValoracionMateria instancia = null;

	/**
	 * 
	 */
	public ControladorValoracionMateria() {
	}

	/**
	 * 
	 * @return
	 */
	public static ControladorValoracionMateria getInstance() {
		if (instancia == null) {
			instancia = new ControladorValoracionMateria();
		}
		return instancia;
	}

	/**
	 * 
	 * @return
	 */
	public ValoracionMateria findByMateriaAndProfesorAndEstudiante (Materia m, Profesor p, Estudiante e) {
		ValoracionMateria resultado = null;
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idMateria = ? and "
					+ "idProfesor = ? and idEstudiante = ?", ValoracionMateria.class);
			q.setParameter(1, m.getId());
			q.setParameter(2, p.getId());
			q.setParameter(3, e.getId());
			resultado = (ValoracionMateria) q.getSingleResult();
			em.close();
		}
		catch (NoResultException nrEx) {
		}
		return resultado;
	}
	
	
	/**
	 * 
	 * @param e
	 */
	public boolean save(ValoracionMateria e) {
		EntityManager em = this.factory.createEntityManager();
		try {
			em.getTransaction().begin();
			if (e.getId() != 0) {
				em.merge(e);
			}
			else {
				em.persist(e);
			}
			em.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
		return true;
	}



	
	

}
