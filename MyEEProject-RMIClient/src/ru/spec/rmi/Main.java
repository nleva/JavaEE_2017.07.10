package ru.spec.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ru.spec.javaee.ejb.EchoService;

public class Main {

	public static void main(String[] args) throws NamingException {
		Context ctx = new InitialContext();
		EchoService echoBean = (EchoService)ctx.lookup("echo");

		System.out.println(echoBean.echo("hello"));
		System.out.println(echoBean.echo2("hello"));

	}

}
