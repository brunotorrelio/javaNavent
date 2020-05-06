package com.brunotorrelio.testnavent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.brunotorrelio.testnavent.dto.ResponseBody;
import com.brunotorrelio.testnavent.models.services.PedidosService;

public class BaseController {
	
	@Autowired
	private PedidosService pedidosService;

	public PedidosService getPedidosService() {
		return pedidosService;
	}
	
	public <T> ResponseBody<T> getResponseBody500(){
		return new ResponseBody<T>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Se ha producido un error interno en el sevidor", null);
	}
	
	public <T> ResponseBody<T> getResponseBody404(){
		return new ResponseBody<T>(HttpStatus.NOT_FOUND.value(), "El pedido no se ha encontrado en el sistema", null);
	}
	
}
