package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Procedure;
import entities.Surgery;
import services.interfaces.ProcedureServicesLocal;
import services.interfaces.ProcedureServicesRemote;

/**
 * Session Bean implementation class ProcedureServices
 */
@Stateless
@LocalBean
public class ProcedureServices implements ProcedureServicesRemote, ProcedureServicesLocal {

	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ProcedureServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addProcedure(Procedure procedure) {
		Boolean b = false;
		try {
			entityManager.persist(procedure);
			b = true;
		} catch (Exception e) {
			System.err.println("error adding procedure");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Procedure> findAllProcedures() {
		String jpql="select p from Procedure p";
		Query query=entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Boolean updateProcedure(Procedure procedure) {
		Boolean b = false;
		try {
			entityManager.merge(procedure);
			b = true;

		} catch (Exception e) {
			System.err.println("Error updating procedure");
		}
		return b;
	}

	@Override
	public Boolean deleteProcedure(Procedure procedure) {
		Boolean b = false;
		try {
			Procedure procedureFound = entityManager.find(Procedure.class,procedure.getId());
			entityManager.remove(procedureFound);
			b = true;

		} catch (Exception e) {
			System.err.println("Error deleting procedure");
		}
		return b;
	}

}
