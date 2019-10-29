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

import br.unip.ads.pim.config.SwaggerConfig;
import br.unip.ads.pim.model.Usuario;
import br.unip.ads.pim.service.UsuarioService;
import io.swagger.annotations.Api;

@CrossOrigin
@Api(tags = SwaggerConfig.TAG_USUARIO)
@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<Iterable<Usuario>> buscarTodos() {
		Iterable<Usuario> entidades = this.service.buscarTodos();
		return ResponseEntity.ok(entidades);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarUm(@PathVariable Long id) {
		final Usuario entidade = this.service.buscarUm(id);
		return ResponseEntity.ok(entidade);
	}

	@PostMapping
	public ResponseEntity<Void> incluir(@RequestBody Usuario entidade) {
		this.service.inserir(entidade);
		URI uri = super.criarUri(entidade.getId());
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Usuario entidade) {
		this.service.alterar(id, entidade);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		this.service.deletar(id);
		return ResponseEntity.ok().build();
	}
}
