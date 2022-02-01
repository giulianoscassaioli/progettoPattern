package business;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class GestioneMuseoEJB
 */
@Stateless
@LocalBean
public class GestioneMuseoEJB implements GestioneMuseoEJBLocal {

	
	@PersistenceContext(unitName = "calcioPS")
	EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public GestioneMuseoEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public EntityManager getEntityManager() {
    	
    	return em;
    }
	
	

}
