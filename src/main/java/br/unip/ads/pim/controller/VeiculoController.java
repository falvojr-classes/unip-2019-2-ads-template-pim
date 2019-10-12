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
import br.unip.ads.pim.model.Veiculo;
import br.unip.ads.pim.service.VeiculoService;
import io.swagger.annotations.Api;

@CrossOrigin
@Api(tags = SwaggerConfig.TAG_VEICULO)
@RestController
@RequestMapping("/veiculos")
public class VeiculoController extends BaseController {

	@Autowired
	private VeiculoService service;

	@GetMapping
	public ResponseEntity<Iterable<Veiculo>> buscarTodos() {
		Iterable<Veiculo> entidades = this.service.buscarTodos();
		return ResponseEntity.ok(entidades);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscarUm(@PathVariable Long id) {
		final Veiculo entidade = this.service.buscarUm(id);
		return ResponseEntity.ok(entidade);
	}

	@PostMapping
	public ResponseEntity<Void> incluir(@RequestBody Veiculo entidade) {
		this.service.inserir(entidade);
		URI uri = super.criarUri(entidade.getId());
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Veiculo entidade) {
		this.service.alterar(id, entidade);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		this.service.deletar(id);
		return ResponseEntity.ok().build();
	}
}
