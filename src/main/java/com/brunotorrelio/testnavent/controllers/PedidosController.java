package com.brunotorrelio.testnavent.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunotorrelio.testnavent.dto.PedidoDTO;
import com.brunotorrelio.testnavent.dto.ResponseBody;
import com.brunotorrelio.testnavent.models.entities.Pedido;
import com.brunotorrelio.testnavent.utils.Utils;

@RestController
@RequestMapping("/pedidos")
public class PedidosController extends BaseController{
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody<PedidoDTO>> getPedido(@PathVariable Integer id){
		ResponseBody<PedidoDTO> responseBody = new ResponseBody<PedidoDTO>();
		
		try {
			Pedido pedido = getPedidosService().getPedidoById(id);
			
			if(pedido != null) {
				
				PedidoDTO pedidoDTO = new PedidoDTO();
				pedidoDTO = (PedidoDTO) Utils.copyPropertiesObject(pedido, pedidoDTO);
				
				responseBody.setData(pedidoDTO);
			}
			responseBody.setCode(HttpStatus.OK.value());
			responseBody.setMessage("success");
			
			return new ResponseEntity<ResponseBody<PedidoDTO>>(responseBody, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponseBody<PedidoDTO>>(getResponseBody500(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<ResponseBody<PedidoDTO>> savePedido(@RequestBody PedidoDTO pedidoDTO){
		ResponseBody<PedidoDTO> responseBody = new ResponseBody<PedidoDTO>();
		
		try {
			
			if(pedidoDTO.getNombre() == null || pedidoDTO.getMonto() == null) {
				responseBody.setCode(HttpStatus.BAD_REQUEST.value());
				responseBody.setMessage("El nombre del pedido y el monto no deben ser nulos");
				return new ResponseEntity<ResponseBody<PedidoDTO>>(responseBody, HttpStatus.BAD_REQUEST);
			}
						
			getPedidosService().savePedido(pedidoDTO);
			responseBody.setCode(HttpStatus.CREATED.value());
			responseBody.setMessage("Pedido creado exitosamente");
			
			return new ResponseEntity<ResponseBody<PedidoDTO>>(responseBody, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponseBody<PedidoDTO>>(getResponseBody500(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/editar")
	public ResponseEntity<ResponseBody<PedidoDTO>> updatePedido(@RequestBody PedidoDTO pedidoDTO){
		ResponseBody<PedidoDTO> responseBody = new ResponseBody<PedidoDTO>();
		
		try {
			
			Integer idPedido = getPedidosService().updatePedido(pedidoDTO);
			
			if(idPedido == null) {
				return new ResponseEntity<ResponseBody<PedidoDTO>>(getResponseBody404(), HttpStatus.NOT_FOUND);				
			}
			
			responseBody.setCode(HttpStatus.OK.value());
			responseBody.setMessage("Pedido modificado exitosamente");
			
			return new ResponseEntity<ResponseBody<PedidoDTO>>(responseBody, HttpStatus.OK);			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponseBody<PedidoDTO>>(getResponseBody500(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<ResponseBody<PedidoDTO>> deletePedido(@PathVariable Integer id){
		ResponseBody<PedidoDTO> responseBody = new ResponseBody<PedidoDTO>();
		
		try {
			
			Integer idPedido = getPedidosService().deletePedido(id);
			
			if(idPedido == null) {
				return new ResponseEntity<ResponseBody<PedidoDTO>>(getResponseBody404(), HttpStatus.NOT_FOUND);				
			}
			
			responseBody.setCode(HttpStatus.OK.value());
			responseBody.setMessage("Pedido eliminado exitosamente");
					
			
			return new ResponseEntity<ResponseBody<PedidoDTO>>(responseBody, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponseBody<PedidoDTO>>(getResponseBody500(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
