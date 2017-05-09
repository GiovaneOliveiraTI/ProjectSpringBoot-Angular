package br.com.fabricadev.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadev.ws.model.Usuario;
import br.com.fabricadev.ws.service.UsuarioService;





@RestController
public class loginController {

	@RequestMapping(value="/autenticar",consumes=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public void autenticar(@RequestBody Usuario usuario) {
		
		System.out.println(usuario.getNome()+ " " + usuario.getSenha());
		// Consulta no Banco
		

	}
	
	UsuarioService usuarioService;

}
