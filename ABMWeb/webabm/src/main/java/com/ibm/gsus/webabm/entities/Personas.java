package com.ibm.gsus.webabm.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Personas {
	
	//@JsonProperty("Id")
	private String _id;
	//@JsonProperty("nombre")
	private String nombre;
	//@JsonProperty("apellido")
	private String apellido;
	//@JsonProperty("dni")
	private Integer dni;
	private String _rev;
	
	public Personas() {
		
		
	}
	

	public Personas(String id, String nombre, String apellido, Integer dni) {
		this._id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}


	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}


	public String get_rev() {
		return _rev;
	}


	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	
	
	
	

}
