package com.ibm.gsus.webabm.webabm;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.gsus.webabm.entities.Personas;
import com.ibm.gsus.webapp.connections.Dbconn;
import com.ibm.gsus.webapp.dao.Dao;

@Path("/empleados")

public class Resource {

	Dao dao = new Dao();
	@GET  
	@Path("/echo/{message}")  
	@Produces("text/plain")  
	public String showMsg(@PathParam("message") String message){  
	    //return message;     
	    Dbconn dbSingleton = Dbconn.getInstance();
	    return dbSingleton.testDatabase().info().toString();
	} 

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public List<Personas> getAllPersons() {
		try {
			dao = new Dao();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return dao.listaDePersonas();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public String registrarPersona(Personas persona) {

		
		String response = dao.registrarPersona(persona);
		
		return response;

	
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public Personas consulta(@PathParam("id") String id) {

		Personas persona = dao.mostrarPersona(id);
		
		return persona;
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public String eliminarPersona(@PathParam("id") String id) {

		try {

			dao = new Dao();
			dao.delete(id);

			return "OK";
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public String updatepersona(@PathParam("id") String id, Personas persona) {

		try {

			dao = new Dao();
			persona.setId(id);
			dao.update(persona);

			return "OK";

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
