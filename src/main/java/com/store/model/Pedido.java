package com.store.model;

import java.util.ArrayList;

public class Pedido {
	private String cedula;
	private String nombre;
	private ArrayList<Integer> productos;
	private Direccion direccion;
	private int idFactura;
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Integer> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Integer> productos) {
		this.productos = productos;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	
	
}
