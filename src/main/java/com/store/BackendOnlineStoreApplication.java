package com.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.store.model.DataBase;
import com.store.model.Producto;

@SpringBootApplication
public class BackendOnlineStoreApplication {

	public static void main(String[] args) {
		Producto product1 = new Producto("Papitas de Limon", 55000);
		Producto product2 = new Producto("Papitas de Natural", 20000);
		Producto product3 = new Producto("Papitas de Tomate", 30000);
		Producto product4 = new Producto("Papitas de Pollo", 40000);
		Producto product5 = new Producto("Papitas de Aguacate", 77777);
		
		DataBase.agregarProducto(product1);
		DataBase.agregarProducto(product2);
		DataBase.agregarProducto(product3);
		DataBase.agregarProducto(product4);
		DataBase.agregarProducto(product5);
		
		SpringApplication.run(BackendOnlineStoreApplication.class, args);
	}

}
