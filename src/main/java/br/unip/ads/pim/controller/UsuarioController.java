package br.unip.ads.pim.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unip.ads.pim.model.Usuario;
import br.unip.ads.pim.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<Iterable<Usuario>> buscarTodos() {
		Iterable<Usuario> usuarios = this.service.buscarTodos();
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarUm(@PathVariable Long id) {
		final Usuario usuario = this.service.buscarUm(id);
		return ResponseEntity.ok(usuario);
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<Void> incluir(@RequestBody Usuario usuario) {
		this.service.inserir(usuario);
		URI uri = super.criarUri(usuario);
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
		this.service.alterar(id, usuario);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		this.service.deletar(id);
		return ResponseEntity.ok().build();
	}
}
