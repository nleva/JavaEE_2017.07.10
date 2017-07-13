/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spec.javaee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import ru.spec.javaee.aop.LogTime;

@Stateless(mappedName="echo")
@LocalBean
public class NewSessionBean implements EchoService {

	@Override
	@LogTime
	public String echo(String msg) {
		return "re:" + msg;
	}
	@Override
	@LogTime(printResult=true)
	public String echo2(String msg) {
		return "re2:" + msg;
	}
}
