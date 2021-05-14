package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;
import model.entities.TipologiaSexo;


public class ControladorEstudiante {

	private static ControladorEstudiante instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoBBDD"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorEstudiante getInstance () {
		if (instance == null) {
			instance = new ControladorEstudiante();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorEstudiante() {
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Estudiante findPrimero () {
		Estudiante c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id limit 1", Estudiante.class);
		c = (Estudiante) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public Estudiante findUltimo () {
		Estudiante c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id desc limit 1", Estudiante.class);
		c = (Estudiante) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public Estudiante findSiguiente (int idActual) {
		Estudiante c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id > ? order by id limit 1", Estudiante.class);
		q.setParameter(1, idActual);
		c = (Estudiante) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @return
	 */
	public Estudiante findAnterior (int idActual) {
		Estudiante c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id < ? order by id desc limit 1", Estudiante.class);
		q.setParameter(1, idActual);
		c = (Estudiante) q.getSingleResult();
		em.close();
		
		return c;		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Estudiante c) {
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
	public void borrar(Estudiante c) {
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
	public List<Estudiante> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
		
		List<Estudiante> list = (List<Estudiante>) q.getResultList();
		em.close();
		return list;
	}

	/**
	 * 
	 * @param idPro
	 * @param idMat
	 * @param idNot
	 * @return
	 */
	public List<Estudiante> findByProMatNot(int idPro, int idMat, float idNot) {
        List<Estudiante> lista = null; 

        EntityManager em = factory.createEntityManager();
        Query q = em.createNativeQuery("Select * from centroeducativo.estudiante join valoracionmateria on estudiante.id=idEstudiante where idProfesor = ? and idMateria = ? and valoracion = ?", Estudiante.class);
        q.setParameter(1, idPro);
        q.setParameter(2, idMat);
        q.setParameter(3, idNot);
        lista = q.getResultList();
        em.close();

        return lista;
    }
	
	/**
	 * 
	 * @param idPro
	 * @param idMat
	 * @param idNot
	 * @return
	 */
    public List<Estudiante> findLeftJoin(int idPro, int idMat, float idNot) {
        List<Estudiante> lista = null; 

        EntityManager em = factory.createEntityManager();
        Query q = em.createNativeQuery("select * from estudiante E left join (select idEstudiante from valoracionmateria where idProfesor=? and idMateria=? and valoracion=?) T on E.id=T.idEstudiante where T.idEstudiante is null", Estudiante.class);
        q.setParameter(1, idPro);
        q.setParameter(2, idMat);
        q.setParameter(3, idNot);
        lista = (List<Estudiante>) q.getResultList();
        em.close();

        return lista;
    }
	

}
