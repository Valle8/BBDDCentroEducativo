package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;


public class ControladorValoracionMateria {

	private static ControladorValoracionMateria instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoBBDD"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorValoracionMateria getInstance () {
		if (instance == null) {
			instance = new ControladorValoracionMateria();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorValoracionMateria() {
	}
	
	
	/**
	 * 
	 * @return
	 */
	public ValoracionMateria findPrimero () {
		ValoracionMateria c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.valoracionmateria order by id limit 1", ValoracionMateria.class);
		c = (ValoracionMateria) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public ValoracionMateria findUltimo () {
		ValoracionMateria c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.valoracionmateria order by id desc limit 1", ValoracionMateria.class);
		c = (ValoracionMateria) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public ValoracionMateria findSiguiente (int idActual) {
		ValoracionMateria c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.valoracionmateria where id > ? order by id limit 1", ValoracionMateria.class);
		q.setParameter(1, idActual);
		c = (ValoracionMateria) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public ValoracionMateria findAnterior (int idActual) {
		ValoracionMateria c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.valoracionmateria where id < ? order by id desc limit 1", ValoracionMateria.class);
		q.setParameter(1, idActual);
		c = (ValoracionMateria) q.getSingleResult();
		em.close();
		
		return c;		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (ValoracionMateria c) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (c.getId() == 0) {
				em.persist(c);
			}
			else {
				em.merge(c);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(ValoracionMateria c) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		if (!em.contains(c)) {
			c = em.merge(c);
		}
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 * @param profesor
	 * @param materia
	 * @param estudiante
	 * @return
	 */
	public ValoracionMateria findByEstudianteAndProfesorAndMateria (Profesor profesor, Materia materia, Estudiante estudiante) {
		ValoracionMateria salida = null;
		EntityManager em = factory.createEntityManager();
		try {
			Query q = em.createNativeQuery("Select * from valoracionmateria where idProfesor = ? and "
					+ "idMateria = ? and idEstudiante = ?", ValoracionMateria.class);
			q.setParameter(1, profesor.getId());
			q.setParameter(2, materia.getId());
			q.setParameter(3, estudiante.getId());
			salida = (ValoracionMateria) q.getSingleResult();
		}
		catch (Exception ex) {
		}
		em.close();
		return salida;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<ValoracionMateria> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria", ValoracionMateria.class);
		
		List<ValoracionMateria> list = (List<ValoracionMateria>) q.getResultList();
		em.close();
		return list;
	}

	
	

}
