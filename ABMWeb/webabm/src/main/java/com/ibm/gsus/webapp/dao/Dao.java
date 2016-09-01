package com.ibm.gsus.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.ibm.gsus.webabm.entities.Personas;
import com.ibm.gsus.webapp.connections.Dbconn;


public class Dao {

	 public String registrarPersona(Personas persona){
    	 Dbconn dbSingleton = Dbconn.getInstance();
    	 Database db = dbSingleton.testDatabase();
    	 persona.setId(persona.getNombre());
    	 Response response = db.post(persona);
    	 return response.getId() + " ; " + db.getDBUri();

     } 

	 public Personas mostrarPersona (String id){
    	 Dbconn dbSingleton = Dbconn.getInstance();
    	 Database db = dbSingleton.testDatabase();
    	 
    	 Personas persona = db.findByIndex("\"selector\": { \"_id\": \""+id+"\"}",Personas.class).get(0);
    	 
    	 return persona;
    	 
     } 

	public List<Personas> listaDePersonas() {
		Dbconn dbSingleton = Dbconn.getInstance();
   	 	Database db = dbSingleton.testDatabase();
   	 	
		 List<Personas> list = db.findByIndex("\"selector\": { \"_id\": { \"$gt\": 0} }",Personas.class);
		 return list;

	}		
	
	 public void delete(String id)
	    {
	    	 Dbconn dbSingleton = Dbconn.getInstance();
	    	 Database db = dbSingleton.testDatabase();
	    	
	    	Personas persona = db.find(Personas.class, id);
	    	 db.remove(persona);
	    	
	    	
	    }

	  public void update(Personas persona)
	     {
	      	 Dbconn dbSingleton = Dbconn.getInstance();
	    	 Database db = dbSingleton.testDatabase();
	    	 db.update(persona);
	    	 }
	


//	
//	public void update(Persons persona) {
//		
//
//		try {
//			PreparedStatement update = conn.prepareStatement("update personas set nombre=?, apellido=?, dni=? where id=?");
//			
//			update.setString(1, persona.getNombre());
//			update.setString(2, persona.getApellido());
//			update.setInt(3, persona.getDni());
//			update.setLong(4, persona.getId());
//			update.executeUpdate();
//			
//		} 
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

}