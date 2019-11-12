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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unip.ads.pim.config.SwaggerConfig;
import br.unip.ads.pim.model.Ocorrencia;
import br.unip.ads.pim.service.OcorrenciaService;
import io.swagger.annotations.Api;

@CrossOrigin
@Api(tags = SwaggerConfig.TAG_OCORRENCIA)
@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController extends BaseController {

	@Autowired
	private OcorrenciaService service;

	@GetMapping
	public ResponseEntity<Iterable<Ocorrencia>> buscarTodos(
			@RequestParam(name = "idFuncionario", required = false) Long idFuncionario,
			@RequestParam(name = "idVeiculo", required = false) Long idVeiculo) {
		Iterable<Ocorrencia> entidades = this.service.buscarTodos(idFuncionario, idVeiculo);
		return ResponseEntity.ok(entidades);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ocorrencia> buscarUm(@PathVariable Long id) {
		final Ocorrencia entidade = this.service.buscarUm(id);
		return ResponseEntity.ok(entidade);
	}

	@PostMapping
	public ResponseEntity<Void> incluir(@RequestBody Ocorrencia entidade) {
		this.service.inserir(entidade);
		URI uri = super.criarUri(entidade.getId());
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Ocorrencia entidade) {
		this.service.alterar(id, entidade);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		this.service.deletar(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/encerrar/{id}")
	public ResponseEntity<Void> encerrar(@PathVariable Long id, @RequestBody Ocorrencia entidade) {
		this.service.encerrar(id, entidade);
		return ResponseEntity.ok().build();
	}
}
