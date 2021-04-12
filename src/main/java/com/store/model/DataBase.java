package com.store.model;

import java.util.HashMap;

public class DataBase {
	private static HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
	private static HashMap<Integer, Producto> productos = new HashMap<Integer, Producto>();
	
	public static void agregarCliente(Cliente cliente) {
		clientes.put( cliente.getCedula(), cliente );
	}
	
	public static void agregarProducto(Producto producto) {
		productos.put( producto.getId(), producto );
	}
	
	public static Producto buscarProducto(int idProducto) {
		return productos.get(idProducto);
	}
	
	public static Cliente buscarCliente(String cedula) {
		return clientes.get(cedula);
	}
}
