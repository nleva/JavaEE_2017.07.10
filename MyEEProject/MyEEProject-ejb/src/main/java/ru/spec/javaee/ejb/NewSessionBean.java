/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spec.javaee.ejb;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import ru.spec.javaee.aop.LogTimeInterceptor;

import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class NewSessionBean {

	@Interceptors(LogTimeInterceptor.class)
//	@LogTime
	public String echo(String msg) {
		return "re:" + msg;
	}
}
