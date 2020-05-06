package com.brunotorrelio.testnavent.models.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunotorrelio.testnavent.cache.BumexMemcached;
import com.brunotorrelio.testnavent.dto.PedidoDTO;
import com.brunotorrelio.testnavent.models.dao.PedidosDAO;
import com.brunotorrelio.testnavent.models.entities.Pedido;
import com.brunotorrelio.testnavent.models.services.PedidosService;
import com.brunotorrelio.testnavent.utils.Utils;

@Service
public class PedidosServiceImpl implements PedidosService {
	
	@Autowired
	private PedidosDAO pedidosDAO;
	
	@Override
	public PedidosDAO getPedidosDAO() {
		return pedidosDAO;
	}

	@Override
	public synchronized void savePedido(PedidoDTO pedidoDTO) throws Exception {
		
		Integer newId = pedidosDAO.getNextId();
				
		Pedido pedido = new Pedido();
		pedido = (Pedido) Utils.copyPropertiesObject(pedidoDTO, pedido);
		pedido.setIdPedido(newId);
		
		pedidosDAO.insertOrUpdate(pedido);
		BumexMemcached.getInstance().set(pedido.getIdPedido().toString(), pedido);
		
	}

	@Override
	public Integer updatePedido(PedidoDTO pedidoDTO) throws Exception {
		Pedido pedido = getPedidoById(pedidoDTO.getIdPedido());
		
		if(pedido == null) {
			return null;
		}
		
		pedido.setNombre(pedidoDTO.getNombre());
		pedido.setMonto(pedidoDTO.getMonto());
		pedido.setDescuento(pedidoDTO.getDescuento());
		
		pedidosDAO.insertOrUpdate(pedido);
		BumexMemcached.getInstance().set(pedido.getIdPedido().toString(), pedido);
		
		return pedido.getIdPedido();
	}

	@Override
	public Pedido getPedidoById(Integer idPedido) throws Exception {
		
		Pedido pedido = (Pedido) BumexMemcached.getInstance().get(idPedido.toString());
		
		if(pedido == null) {
			pedido = pedidosDAO.select(idPedido);
		}
		
		return pedido;
	}

	@Override
	public Integer deletePedido(Integer idPedido) throws Exception {
		
		Pedido pedido = getPedidoById(idPedido);
		
		if(pedido == null) {
			return null;
		}
		
		pedidosDAO.delete(pedido);
		BumexMemcached.getInstance().delete(pedido.getIdPedido().toString());
		return idPedido;
	}
	
}
