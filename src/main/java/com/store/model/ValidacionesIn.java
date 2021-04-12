package com.store.model;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ValidacionesIn {

	private static String cedula;
	private static String nombre;
	private static ArrayList<Integer> idProductos; 
	private static Direccion direccion;
	private static Integer id;
	
	public static void validarGetPedido(Pedido pedido) {
		try {
			validarCedula( pedido );
			validarNombre( pedido );
			validarProductos( pedido );
			validarDireccion( pedido );
			
		} catch (NullPointerException e) {
			relanzarNullPointer();
		}	
	}
	
	public static void validarPatchPedido( Pedido pedido ) {	
		try {
			validarCedula( pedido );
			validarProductos( pedido );
			validarIdFactura( pedido );
			
		} catch (NullPointerException e) {
			relanzarNullPointer();
		}
	}
	
	public static void validarEliminarPedido( Pedido pedido ) {
		try {
			validarCedula( pedido );
			validarIdFactura( pedido );
						
		} catch (NullPointerException e) {
			relanzarNullPointer();
		}
	}
	
	private static void validarCedula( Pedido pedido ) {
		cedula = pedido.getCedula();
		if( cedula.isEmpty() ) {
			System.out.println("Datos incorrectos, cedula vacío");
			throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST, "La cedula no existe");
		}
	}
	
	private static void validarNombre( Pedido pedido ) {
		nombre = pedido.getNombre();
		if( nombre.isEmpty() ) {
			System.out.println("Datos incorrectos, nombre vacío");
			throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST, "Datos incorrectos, nombre vacío");
		}
	}
	
	private static void validarProductos( Pedido pedido ) {
		idProductos = pedido.getProductos();
		if(idProductos.size() == 0) {
			System.out.println("No hay productos para comprar");
			throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST, "No hay productos para comprar");
		}
	}
	
	private static void validarDireccion( Pedido pedido ) {
		direccion = pedido.getDireccion();
		if( direccion.getPais().isEmpty() || direccion.getCiudad().isEmpty() || direccion.getBarrio().isEmpty() || direccion.getDireccion().isEmpty()) {
			System.out.println("La dirección no cumple con los parametros correctos");
			throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST, "La dirección no cumple con los parametros correctos");
		}
	}
	
	private static void validarIdFactura( Pedido pedido ) {
		id = pedido.getIdFactura();
		if( id == 0 ) {
			System.out.println("Datos incorrectos, id vacío");
			throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST, "Datos incorrectos, id vacío");
		}	
	}
	
	private static void relanzarNullPointer() {
		System.out.println("Hay datos obligatorios que no existen");
		throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Hay datos obligatorios que no existen");
	}
	
}
