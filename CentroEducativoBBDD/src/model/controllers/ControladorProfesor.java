package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Profesor;


public class ControladorProfesor {

	private static ControladorProfesor instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPACoches"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorProfesor getInstance () {
		if (instance == null) {
			instance = new ControladorProfesor();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorProfesor() {
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Profesor findPrimero () {
		Profesor c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor order by id limit 1", Profesor.class);
		c = (Profesor) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public Profesor findUltimo () {
		Profesor c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor order by id desc limit 1", Profesor.class);
		c = (Profesor) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public Profesor findSiguiente (int idActual) {
		Profesor c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor where id > ? order by id limit 1", Profesor.class);
		q.setParameter(1, idActual);
		c = (Profesor) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public Profesor findAnterior (int idActual) {
		Profesor c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor where id < ? order by id desc limit 1", Profesor.class);
		q.setParameter(1, idActual);
		c = (Profesor) q.getSingleResult();
		em.close();
		
		return c;		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Profesor c) {
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
	public void borrar(Profesor c) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		if (!em.contains(c)) {
			c = em.merge(c);
		}
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

	
	

}
