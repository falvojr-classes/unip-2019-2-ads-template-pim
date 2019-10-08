package br.unip.ads.pim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unip.ads.pim.model.Usuario;
import br.unip.ads.pim.service.UsuarioService;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

	@Autowired
	private UsuarioService usuarioService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Usuario> logar(@RequestBody Usuario credenciais) {
		Usuario usuario = usuarioService.logar(credenciais);
		return ResponseEntity.ok(usuario);
	}
}
