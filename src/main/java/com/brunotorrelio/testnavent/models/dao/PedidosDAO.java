package com.brunotorrelio.testnavent.models.dao;

import com.brunotorrelio.testnavent.models.entities.Pedido;

public interface PedidosDAO {
	
	void insertOrUpdate(Pedido pedido);
	
	void delete(Pedido pedido);
	
	Pedido select(Integer idPedido);
	
	Integer getNextId();
	
}
