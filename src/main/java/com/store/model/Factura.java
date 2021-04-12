package com.store.model;

import java.time.LocalDateTime;

public class Factura {
	private int id;
	private String estadoFactura = "ACTIVA";
	private double totalNeto;
	private double multaCancelacion;
	private double totalPay;
	private LocalDateTime createdAt;
	private double costship;
	private double totalIva;
	private final double IVA = 0.19;
	private final double RECARGO_CANCELAR = 0.10;
	private static int contador;
	
	public Factura(double totalNeto) {
		contador += 1;
		this.id = contador;
		this.totalNeto = totalNeto;
		createdAt = LocalDateTime.now();
		calcularIvaEnvio( totalNeto );
	}
	
	private void calcularIvaEnvio( double totalNeto) {
		if( totalNeto>70000 ) {
			costship = 10000;
			totalIva = totalNeto*IVA;
			totalPay = totalNeto + totalIva + costship;
		}else if( totalNeto>100000 ) {
			costship = 0;
			totalIva = totalNeto*IVA;
			totalPay = totalNeto + totalIva;
		}else {
			totalIva = 0;
			costship = 0;
			totalPay = totalNeto;
		}
		
		this.totalNeto = totalNeto;
	}
	
	public double eliminarFactura() {
		id = -1*id;
		multaCancelacion = totalPay * RECARGO_CANCELAR;
		totalPay = multaCancelacion;
		totalNeto = 0;
		costship = 0;
		estadoFactura = "CANCELADA";
		return totalPay;
	}

	public int getId() {
		return id;
	}

	public double getTotalNeto() {
		return totalNeto;
	}

	public void setTotalNeto(double totalNeto) {
		calcularIvaEnvio( totalNeto );
	}

	public double getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(double totalPay) {
		this.totalPay = totalPay;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public double getCostship() {
		return costship;
	}

	public void setCostship(double costship) {
		this.costship = costship;
	}

	public double getTotalIva() {
		return totalIva;
	}

	public void setTotalIva(double totalIva) {
		this.totalIva = totalIva;
	}
	
	public String getEstadoFactura() {
		return estadoFactura;
	}

	public void setEstadoFactura(String estadoFactura) {
		this.estadoFactura = estadoFactura;
	}
	public double getMultaCancelacion() {
		return multaCancelacion;
	}
	public void setMultaCancelacion(double multaCancelacion) {
		this.multaCancelacion = multaCancelacion;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", totalNeto=" + totalNeto + ", totalPay=" + totalPay + ", dateMade=" + createdAt
				+ ", costship=" + costship + ", totalIva=" + totalIva + "]";
	}

}
