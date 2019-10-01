package br.unip.ads.pim.controller;

import java.net.URI;
import java.util.Optional;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unip.ads.pim.model.Usuario;
import br.unip.ads.pim.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public ResponseEntity<Iterable<Usuario>> buscarTodos() {
		Iterable<Usuario> usuarios = this.usuarioRepository.findAll();
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarUm(@PathVariable Long id) {
		final Optional<Usuario> usuarioBD = this.usuarioRepository.findById(id);
		return usuarioBD.isPresent() ? ResponseEntity.ok(usuarioBD.get()) : ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Void> incluir(@RequestBody Usuario usuario) {
		this.usuarioRepository.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
		Optional<Usuario> usuarioBD = this.usuarioRepository.findById(id);
		if (usuarioBD.isPresent()) {
			this.usuarioRepository.save(usuario);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		Optional<Usuario> usuarioBD = this.usuarioRepository.findById(id);
		if (usuarioBD.isPresent()) {
			this.usuarioRepository.delete(usuarioBD.get());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
