package ru.spec.javaee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class CheckListService
 */
@Stateless
@LocalBean
public class CheckListService implements CheckListServiceRemote {

	@PersistenceContext
	EntityManager em;
	
   

}
