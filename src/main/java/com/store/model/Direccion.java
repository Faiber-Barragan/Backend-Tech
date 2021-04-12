package com.store.model;

public class Direccion {
	private String pais;
	private String ciudad;
	private String barrio;
	private String direccion;
	
	public Direccion(String pais, String ciudad, String barrio, String direccion) {
		this.pais = pais;
		this.ciudad = ciudad;
		this.barrio = barrio;
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Direccion [pais=" + pais + ", ciudad=" + ciudad + ", barrio=" + barrio + ", direccion=" + direccion
				+ "]";
	}
	
	
	
	
}
