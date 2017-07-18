package ru.spec.javaee.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.spec.javaee.entity.CheckList;
import ru.spec.javaee.entity.Option;

/**
 * Session Bean implementation class CheckListService
 */
@Stateless(mappedName="CheckListService")
@LocalBean
public class CheckListService implements CheckListServiceRemote {

	@Inject
	EntityManager em;
	
	@Inject
	Logger log;
	
	@Inject
	CheckListService self;
	
	@Resource
	SessionContext ctx;
	
	@Override
	public List<CheckList> getCheckLists(/*Long id*/) {
		List<CheckList> resultList = em.createQuery("SELECT cl FROM CheckList cl "
				+ ""
//				+ "WHERE cl.id = :cl_ID "
				+ ""
				+ "", CheckList.class)
			.setFirstResult(0)
			.setMaxResults(10)
//			.setParameter("cl_ID", id)
			.getResultList();
		
		return resultList;
	}
   
	@Override
	public CheckList createCheckList(String name) {
		CheckList item = new CheckList();
		item.setText(name);
//		System.out.println(item);
		em.persist(item);
//		em.flush();
//		System.out.println(item.getId());
		
//		throw new RuntimeException("test rollBack");
		
		return item;
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Option createOption(String text, Long checkListId) {
		
		CheckList cl = em.find(CheckList.class, checkListId);
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			ctx.setRollbackOnly();
		}
		
		return createOption(text, cl);
	}

	@Override
	public Option createOption(String text, CheckList cl) {
		Option option = new Option();
		option.setText(text);
//		cl.addOption(option);
		option.setCheckList(cl);
		em.persist(option);
		
		
		createOptions(7L,"123","asd","asd","asxcv");
		return option;
	}
	
	public List<Option> createOptions(Long cl, String...text ) {
		for (String string : text) {
			self.createOption(string, cl);
		}
		return null;
	}

}
