package com.store.rest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.store.model.Cliente;
import com.store.model.DataBase;
import com.store.model.Direccion;
import com.store.model.Factura;
import com.store.model.Pedido;
import com.store.model.Producto;
import com.store.model.ValidacionesIn;


@RestController
@RequestMapping("api")
public class PedidoRest {

	Cliente cliente;
	Factura factura;
	Producto producto;
	String cedula;
	String nombre;
	double precioNeto = 0;
	ArrayList<Integer> idProductos; 
	Direccion direccion;
	int idFactura;
	double horasPasadas;
	
	@PostMapping("/pedido")
	public Factura guardarPedido( @RequestBody Pedido pedido ) {		
		ValidacionesIn.validarGetPedido(pedido);

		precioNeto = 0;
		cedula = pedido.getCedula();
		nombre = pedido.getNombre();
		idProductos = pedido.getProductos();
		direccion = pedido.getDireccion();
		
		cliente = DataBase.buscarCliente(cedula);
				
		if( cliente == null) {
			cliente = new Cliente(cedula, nombre, direccion);
		}		
		
		for(int id : idProductos ) {
			producto = DataBase.buscarProducto(id);
			if( producto == null) {
				System.out.println("El producto "+id+" no existe");
				throw new ResponseStatusException(
		                HttpStatus.BAD_REQUEST, "El producto "+id+" no existe");
			}else {
				precioNeto += DataBase.buscarProducto(id).getPrice();
			}
		}
		
		factura = new Factura(precioNeto);
		cliente.agregarFactura(factura);
		DataBase.agregarCliente(cliente);
		
		return factura;
	}
	
	
	@PatchMapping("/pedido")
	public Factura actualizarPedido( @RequestBody Pedido pedido ) {
		
		ValidacionesIn.validarPatchPedido(pedido);
		
		cedula = pedido.getCedula();
		idProductos = pedido.getProductos();
		idFactura = pedido.getIdFactura();
		precioNeto = 0;
		
		cliente = DataBase.buscarCliente(cedula);	
		if( cliente == null) {
			System.out.println("La cedula no existe");
			throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST, "La cedula no existe");
		}
		
		factura = cliente.buscarFactura(idFactura);
		if( factura == null ) {
			System.out.println("La factura no existe");
			throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST, "La factura no existe");
		}
		
		horasPasadas = ChronoUnit.HOURS.between( factura.getCreatedAt(), LocalDateTime.now());		

		if( horasPasadas < 5 ) {
			System.out.println("Puede actulizar el pedido después de 5 horas de creado");		
			throw new ResponseStatusException(
	                HttpStatus.UNPROCESSABLE_ENTITY, "Solo puede actulizar el pedido después de 5 horas de creado");
		}

		for(int id : idProductos ) {
			producto = DataBase.buscarProducto(id);
			if( producto != null) {
				precioNeto += DataBase.buscarProducto(id).getPrice();
			}
		}
		
		if( precioNeto < factura.getTotalNeto() ) {
			throw new ResponseStatusException(
	                HttpStatus.UNPROCESSABLE_ENTITY, "Solo puede actulizar el pedido si el nuevo valor es igual o superior al pedido anterior");
		}
		
		factura.setTotalNeto(precioNeto);
		cliente.agregarFactura(factura);
		
		return factura;
	}
	
	@DeleteMapping("/pedido")
	public Factura eliminarPedido( @RequestBody Pedido pedido ) {
		
		ValidacionesIn.validarEliminarPedido(pedido);
		
		double recargo;
		cedula = pedido.getCedula();
		idFactura = pedido.getIdFactura();
		
		cliente = DataBase.buscarCliente(cedula);	
		if( cliente == null) {
			System.out.println("La cedula no existe");
	        throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST, "La cedula no existe");
		}
		
		factura = cliente.buscarFactura(idFactura);
		if( factura == null ) {
			System.out.println("La factura no existe");
	        throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST, "La factura no existe");
		}
		
		horasPasadas = ChronoUnit.HOURS.between( factura.getCreatedAt(), LocalDateTime.now());
		
		if( horasPasadas > 12 ) {
			System.out.println("Ya transcurrieron 12 horas y no es posible eliminar el pedido");
			throw new ResponseStatusException(
	                HttpStatus.UNPROCESSABLE_ENTITY, "Ya transcurrieron 12 horas y no es posible eliminar el pedido");
		}
		
		recargo = factura.eliminarFactura();
		
		
		return factura;
	}
}
