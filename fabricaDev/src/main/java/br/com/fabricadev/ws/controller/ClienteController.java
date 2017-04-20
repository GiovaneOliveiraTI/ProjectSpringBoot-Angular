package br.com.fabricadev.ws.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadev.ws.model.Cliente;
import br.com.fabricadev.ws.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;

	
	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {

		Cliente clienteCadastrado = clienteService.cadastrar(cliente);

		return new ResponseEntity<Cliente>(clienteCadastrado, org.springframework.http.HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Collection<Cliente>> buscarTodosCliente() {

		Collection<Cliente> clientesbuscados = clienteService.buscarTodos();

		return new ResponseEntity<>(clientesbuscados, org.springframework.http.HttpStatus.OK);

	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes{id}")
	private ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {

		Cliente clienteEncontrado = clienteService.buscarPorId(id);
		
		if(clienteEncontrado==null){
			
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);	
			
		}
		clienteService.excluir(clienteEncontrado);

		return new ResponseEntity<Cliente>(org.springframework.http.HttpStatus.OK);

	}



	 Cliente buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
