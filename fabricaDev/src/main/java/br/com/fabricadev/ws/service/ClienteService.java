package br.com.fabricadev.ws.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fabricadev.ws.model.Cliente;
import br.com.fabricadev.ws.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	
	public Cliente cadastrar(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}
	public Collection<Cliente> buscarTodos() {

		return clienteRepository.findAll();
	}

	public void excluir(Cliente cliente) {

		clienteRepository.delete(cliente.getId());

	}

	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {

		Cliente clienteCadastrado = cadastrar(cliente);

		return new ResponseEntity<Cliente>(clienteCadastrado, org.springframework.http.HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosCliente() {

		Collection<Cliente> clientesbuscados = buscarTodos();

		return new ResponseEntity<>(clientesbuscados, org.springframework.http.HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {

		Cliente clienteEncontrado = buscarPorId(id);

		if (clienteEncontrado == null) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		excluir(clienteEncontrado);

		return new ResponseEntity<Cliente>(org.springframework.http.HttpStatus.OK);

	}

	public Cliente buscarPorId(Integer id) {
		
		return clienteRepository.findOne(id);
	}

}
