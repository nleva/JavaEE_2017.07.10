package ru.spec.javaee.ejb;

import javax.ejb.Remote;

@Remote
public interface EchoService {

	String echo(String msg);

	String echo2(String msg);

}