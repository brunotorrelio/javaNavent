package com.brunotorrelio.testnavent.models.entities;

import java.io.Serializable;

public class Pedido implements Serializable{	

	private Integer idPedido;
	
	private String nombre;
	
	private Integer monto;
	
	private Integer descuento;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}	

	private static final long serialVersionUID = 1L;
	
}
