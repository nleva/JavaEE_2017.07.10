package ru.spec.javaee.web;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import ru.spec.javaee.ejb.CheckListService;
import ru.spec.javaee.entity.Option;

@Path("/checkList")
public class CheckListRest {

	@EJB
	CheckListService cl;
	
//	@GET
//	@Path("options-{id:[0-9]+}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_XML)
//	public void getOptions(@PathParam("id") Long checkListId,
//			@QueryParam("msg") String msg) {
//		
//	}
//	@GET
//	@Path("options-{id:[0-9]+}-{msg:[a-zA-Z0-9]+}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public void getOptions2(@PathParam("id") Long checkListId,
//			@PathParam("msg") String msg) {
//		
//	}

	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	
	
	@GET
	public String echo(@QueryParam("msg") String msg) {
		return "re:" + msg;
	}
	
	@POST
	@Path("createOption")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Option createOption(Option o) {
		return cl.createOption(o.getText(), 7L);
	}

}
