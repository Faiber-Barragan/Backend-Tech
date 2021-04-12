package com.store.model;

import java.util.HashMap;

public class Cliente {
	private String cedula;
	private String name;
	private Direccion adress;
	private HashMap<Integer, Factura> facturas;
	
	public Cliente(String cedula, String name, Direccion adress) {
		this.cedula = cedula;
		this.name = name;
		this.adress = adress;
		facturas = new HashMap<Integer, Factura>();
	}
	
	public void agregarFactura( Factura factura ) {
		facturas.put(factura.getId(), factura);
	}
	
	public Factura buscarFactura( int idFactura ) {
		return facturas.get( idFactura );
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Direccion getAdress() {
		return adress;
	}

	public void setAdress(Direccion adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", name=" + name + ", adress=" + adress + ", facturas=" + facturas + "]";
	}
	
	
}
