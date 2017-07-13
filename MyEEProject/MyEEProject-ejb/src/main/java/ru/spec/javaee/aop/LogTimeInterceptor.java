package ru.spec.javaee.aop;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class LogTimeInterceptor {
	
	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception{
		
		
		ctx.getParameters();
		long ts0 = System.nanoTime();
		Object result = ctx.proceed();
		long ts1 = System.nanoTime();
		double delta = (ts1-ts0)/1000/1000.0;
		System.out.println(
				ctx.getTarget().getClass().getSimpleName()
						+"."+ctx.getMethod().getName()
						+"() done in "
						+delta+"ms");
		
		return result;
	}
}
