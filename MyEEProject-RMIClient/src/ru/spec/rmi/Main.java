package ru.spec.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ru.spec.javaee.ejb.EchoService;
import ru.spec.javaee.ejb.MyWizardRemote;

public class Main {

	public static void main(String[] args) throws NamingException {
		Context ctx = new InitialContext();
		MyWizardRemote wizard = (MyWizardRemote)ctx.lookup("wizard");
//		MyWizardRemote wizard2 = (MyWizardRemote)ctx.lookup("wizard");

		wizard.greet("hello from cli");
//		wizard2.get();
		
//		wizard2.greet("qwertyui");
		
		wizard.log();
		System.out.println(wizard.get());
//		System.out.println(wizard2.get());
		
//		interceptors(ctx);

	}

	private static void interceptors(Context ctx) throws NamingException {
		EchoService echoBean = (EchoService)ctx.lookup("echo");

		System.out.println(echoBean.echo("hello"));
		System.out.println(echoBean.echo2("hello"));
	}

}
