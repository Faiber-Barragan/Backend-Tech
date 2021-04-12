package com.store.model;

public class Producto {
	private int id;
	private String name;
	private double price;
	private static int contador;
	
	public Producto(String name, double price) {
		contador += 1;
		this.id = contador;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
