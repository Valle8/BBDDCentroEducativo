package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.TipologiaSexo;


public class ControladorTipologia {

	private static ControladorTipologia instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPACoches"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorTipologia getInstance () {
		if (instance == null) {
			instance = new ControladorTipologia();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorTipologia() {
	}
	
	
	/**
	 * 
	 * @return
	 */
	public TipologiaSexo findPrimero () {
		TipologiaSexo c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiaSexo order by id limit 1", TipologiaSexo.class);
		c = (TipologiaSexo) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public TipologiaSexo findUltimo () {
		TipologiaSexo c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiaSexo order by id desc limit 1", TipologiaSexo.class);
		c = (TipologiaSexo) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public TipologiaSexo findSiguiente (int idActual) {
		TipologiaSexo c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiaSexo where id > ? order by id limit 1", TipologiaSexo.class);
		q.setParameter(1, idActual);
		c = (TipologiaSexo) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public TipologiaSexo findAnterior (int idActual) {
		TipologiaSexo c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiaSexo where id < ? order by id desc limit 1", TipologiaSexo.class);
		q.setParameter(1, idActual);
		c = (TipologiaSexo) q.getSingleResult();
		em.close();
		
		return c;		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (TipologiaSexo c) {
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
	public void borrar(TipologiaSexo c) {
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
	public List<TipologiaSexo> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM tipologiaSexo", TipologiaSexo.class);
		
		List<TipologiaSexo> list = (List<TipologiaSexo>) q.getResultList();
		em.close();
		return list;
	}

	
	

}
