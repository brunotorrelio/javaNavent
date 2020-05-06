package com.brunotorrelio.testnavent.models.services;

import com.brunotorrelio.testnavent.dto.PedidoDTO;
import com.brunotorrelio.testnavent.models.dao.PedidosDAO;
import com.brunotorrelio.testnavent.models.entities.Pedido;

public interface PedidosService {
	
	PedidosDAO getPedidosDAO();
	
	void savePedido(PedidoDTO pedidoDTO) throws Exception;
	
	Integer updatePedido(PedidoDTO pedidoDTO) throws Exception;
	
	Pedido getPedidoById(Integer idPedido) throws Exception;
	
	Integer deletePedido(Integer idPedido) throws Exception;
}
