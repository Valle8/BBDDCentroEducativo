package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Materia;




public class ControladorMateria {

	private static ControladorMateria instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoBBDD"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorMateria getInstance () {
		if (instance == null) {
			instance = new ControladorMateria();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorMateria() {
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Materia findPrimero () {
		Materia c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.materia order by id limit 1", Materia.class);
		c = (Materia) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public Materia findUltimo () {
		Materia c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.materia order by id desc limit 1", Materia.class);
		c = (Materia) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public Materia findSiguiente (int idActual) {
		Materia c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.materia where id > ? order by id limit 1", Materia.class);
		q.setParameter(1, idActual);
		c = (Materia) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public Materia findAnterior (int idActual) {
		Materia c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.materia where id < ? order by id desc limit 1", Materia.class);
		q.setParameter(1, idActual);
		c = (Materia) q.getSingleResult();
		em.close();
		
		return c;		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Materia c) {
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
	public void borrar(Materia c) {
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
	 * @return
	 */
	public List<Materia> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM materia", Materia.class);
		
		List<Materia> list = (List<Materia>) q.getResultList();
		em.close();
		return list;
	}

	
	

}
