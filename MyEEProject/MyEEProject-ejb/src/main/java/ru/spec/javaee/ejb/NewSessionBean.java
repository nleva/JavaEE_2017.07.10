/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spec.javaee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;

import ru.spec.javaee.aop.LogTime;

@Stateless(mappedName = "echo")
@LocalBean
public class NewSessionBean implements EchoService {
	
	@Inject
	Event<UserDto> bus;

	@LogTime
	public void processUser(@Observes UserDto user) {

	}

	@LogTime
	public void checkUser(@Observes(during = TransactionPhase.BEFORE_COMPLETION) UserDto user) {

	}

	@LogTime
	@Override
	public String echo(String msg) {
		UserDto userDto = new UserDto();
		bus.fire(userDto);
		// processUser(userDto);
		// checkUser(userDto);
		return "re:" + msg;
	}

	@Override
	@LogTime(printResult = true)
	public String echo2(String msg) {
		return "re2:" + msg;
	}
}
