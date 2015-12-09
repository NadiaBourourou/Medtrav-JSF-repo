package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Procedure;

@Remote
public interface ProcedureServicesRemote {
	
	Boolean addProcedure(Procedure procedure);
	
	List<Procedure> findAllProcedures();
	
	Boolean updateProcedure(Procedure procedure);

	Boolean deleteProcedure(Procedure procedure);
}
