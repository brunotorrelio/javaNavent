package com.brunotorrelio.testnavent.models.dao.impl;

import org.springframework.stereotype.Repository;

import com.brunotorrelio.testnavent.models.dao.PedidosDAO;
import com.brunotorrelio.testnavent.models.entities.Pedido;

@Repository
public class PedidosDAOImpl implements PedidosDAO {

	@Override
	public void insertOrUpdate(Pedido pedido) {
		
	}

	@Override
	public void delete(Pedido pedido) {
		
	}

	@Override
	public Pedido select(Integer idPedido) {
		return null;
	}

	@Override
	public Integer getNextId() {
		// Este metodo busca de la base de datos el siguiente id de la tabla.
		// Para probar, coloque que devuelva 1 por defecto para que no se dispare un NullPointer
		return 1;
	}

}
