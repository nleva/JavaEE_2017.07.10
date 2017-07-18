package ru.spec.javaee.utils;

import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class JPAUtils {

	@PersistenceContext
	public EntityManager mysql;
	
	@Produces
	@Named
	public EntityManager getMysql(InjectionPoint ip) {
		
		return mysql;
	}
	
	@Produces
	public Logger getLog(InjectionPoint ip) {
		return Logger.getLogger(ip.getBean().getName());
	}
	
}
